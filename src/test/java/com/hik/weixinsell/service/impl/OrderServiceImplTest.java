package com.hik.weixinsell.service.impl;

import com.hik.weixinsell.DTO.OrderDTO;
import com.hik.weixinsell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceImplTest {


    @Autowired
    private OrderServiceImpl orderService;

    private final String OPENID="110110";

    private final String ORDERID="1523325893774722651";

    @Test
    public void creat() {
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setBuyerAddress("aaaa");
        orderDTO.setBuyerName("aaaa");
        orderDTO.setBuyerOpenid(OPENID);
        orderDTO.setBuyerPhone("12313");
        orderDTO.setOrderAmount(new BigDecimal(123));
        List<OrderDetail> orderDetailList=new ArrayList<>();

        OrderDetail o1=new OrderDetail();
        /**
         * 只需要设置两个值？？？？？
         */
        o1.setProductId("1");
        o1.setProductQuantity(2);
        orderDetailList.add(o1);

        OrderDetail o2=new OrderDetail();
        /**
         * 只需要设置两个值？？？？？
         */
        o2.setProductId("1");
        o2.setProductQuantity(2);
        orderDetailList.add(o2);


        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO orderDTO1=orderService.creat(orderDTO);
        System.out.println(orderDTO1);
    }

    @Test
    public void findOne() {
        OrderDTO orderDTO= orderService.findOne(ORDERID);
        System.out.println(orderDTO.getBuyerName());
    }

    @Test
    public void findList() {
        PageRequest pageRequest=new PageRequest(0,2);
        Page<OrderDTO>orderDTOPage=orderService.findList(OPENID,pageRequest);

        System.out.println(orderDTOPage);
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO=orderService.findOne(ORDERID);
        orderService.cancel(orderDTO);
        System.out.println(orderDTO);
    }

    @Test
    public void finish() {
        OrderDTO orderDTO= orderService.findOne(ORDERID);
        orderService.finish(orderDTO);
    }

    @Test
    public void paid() {
        OrderDTO orderDTO= orderService.findOne(ORDERID);
        orderService.paid(orderDTO);
    }
    @Test
    public void list(){
        PageRequest pageRequest=new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage=orderService.findList(pageRequest);
        System.out.println(orderDTOPage);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }
}