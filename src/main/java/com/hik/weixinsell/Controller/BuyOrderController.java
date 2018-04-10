package com.hik.weixinsell.Controller;

import com.hik.weixinsell.DTO.OrderDTO;
import com.hik.weixinsell.VO.ResultVO;
import com.hik.weixinsell.converter.OrderForm2OrderDTOConverter;
import com.hik.weixinsell.enums.ResultEnum;
import com.hik.weixinsell.exception.SellException;
import com.hik.weixinsell.form.OrderForm;
import com.hik.weixinsell.service.impl.OrderServiceImpl;
import com.hik.weixinsell.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping(value = "/buyer/order")
/**
 * 1.创建订单
 * 2.订单列表、
 * 3.订单详情
 * 4.取消订单
 */
public class BuyOrderController {
    @Autowired
    private OrderServiceImpl orderService;
    //创建订单
    @PostMapping(value = "/create")
    public ResultVO<Map<String,String>> creat(@Valid OrderForm orderForm, BindingResult bindingResult){
//        参数不正确
        if(bindingResult.hasErrors()){
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO= OrderForm2OrderDTOConverter.converter(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO creatResult=orderService.creat(orderDTO);
        Map<String,String> map=new HashMap<>();
        map.put("orderId",creatResult.getOrderId());
        return ResultVOUtil.success(map);
    }
    //订单列表
    @GetMapping(value = "/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page",defaultValue = "0")   Integer page,
                                         @RequestParam(value = "size",defaultValue = "10")   Integer size){
        if(StringUtils.isEmpty(openid)){
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest pageRequest=new PageRequest(page,size);

        Page<OrderDTO> orderDTOPage=orderService.findList(openid,pageRequest);

        return ResultVOUtil.success(orderDTOPage);
    }

}
