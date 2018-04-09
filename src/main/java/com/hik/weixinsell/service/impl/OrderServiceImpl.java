package com.hik.weixinsell.service.impl;

import com.hik.weixinsell.DTO.CartDTO;
import com.hik.weixinsell.DTO.OrderDTO;
import com.hik.weixinsell.Repository.OrderDetailRepository;
import com.hik.weixinsell.Repository.OrderMasterRepository;
import com.hik.weixinsell.converter.OrderMaster2OrderDTOConverter;
import com.hik.weixinsell.dataobject.OrderDetail;
import com.hik.weixinsell.dataobject.OrderMaster;
import com.hik.weixinsell.dataobject.ProductInfo;
import com.hik.weixinsell.enums.ResultEnum;
import com.hik.weixinsell.exception.SellException;
import com.hik.weixinsell.service.OrderService;
import com.hik.weixinsell.service.ProductService;
import com.hik.weixinsell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService ;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;




    @Override
    @Transactional
    public OrderDTO creat(OrderDTO orderDTO) {
        /**
         *  创建订单的业务逻辑
         * 1.查询商品（数量，价格）
         * 2.计算总价
         * 3.写入订单数据库（orderaster,orderDetail）
         * 4.扣库存
         */
        String orderId=KeyUtil.getUniqueKey();
        BigDecimal orderAmount=new BigDecimal(0);
        //查询商品
        //判断商品是否存在
        for(OrderDetail orderDetail:orderDTO.getOrderDetailList()){
            ProductInfo productInfo=productService.findOne(orderDetail.getProductId());
            if (productInfo==null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //订单总价，一件商品的总价（for循环得到所有商品的总价）
            orderAmount=productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);


//            保存订单详情
            orderDetail.setOrderId(KeyUtil.getUniqueKey());
            orderDetail.setDetailId(orderId);

            BeanUtils.copyProperties(productInfo,orderDetail);
            orderDetailRepository.save(orderDetail);
        }
//        写入订单数据库
        OrderMaster orderMaster=new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderId(orderId);

        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(0);
        orderMaster.setPayStatus(0);
        orderMasterRepository.save(orderMaster);
//        扣库存
        List<CartDTO> cartDTOList=new ArrayList<CartDTO>();
        cartDTOList=orderDTO.getOrderDetailList().stream().map(e->new CartDTO(e.getProductId(),e.getProductQuantity())).collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);

        return orderDTO;


    }

    /**
     * 查询单个订单
     * @param orderId
     * @return
     */
    @Override
    public OrderDTO findOne(String orderId) {
        OrderMaster orderMaster=orderMasterRepository.findOne(orderId);
        if (orderMaster==null){
            throw new SellException(ResultEnum.ORDER_NO_EXIST);
        }
        //查询订单详情
        List<OrderDetail> orderDetailList=orderDetailRepository.findByOrderId(orderId);
        if(orderDetailList==null){
            throw new SellException(ResultEnum.ORDER_NO_EXIST);
        }
        OrderDTO orderDTO=new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
//        对象需要转换
        Page<OrderMaster>orderMasterPage=orderMasterRepository.findByBuyerOpenid(buyerOpenid,pageable);
        List<OrderDTO> orderDTOList= OrderMaster2OrderDTOConverter.converter(orderMasterPage.getContent());
        Page<OrderDTO> orderDTOPage=new PageImpl<OrderDTO>(orderDTOList,pageable,orderMasterPage.getTotalElements());

        return orderDTOPage;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
