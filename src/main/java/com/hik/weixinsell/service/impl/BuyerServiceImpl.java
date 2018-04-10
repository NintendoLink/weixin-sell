package com.hik.weixinsell.service.impl;

import com.hik.weixinsell.DTO.OrderDTO;
import com.hik.weixinsell.enums.ResultEnum;
import com.hik.weixinsell.exception.SellException;
import com.hik.weixinsell.service.BuyerService;
import org.springframework.stereotype.Service;

@Service
public class BuyerServiceImpl implements BuyerService {

    private OrderServiceImpl orderService;

    @Override
    public OrderDTO findOrderOne(String openId, String orderId) {
        return checkOrderOwner(openId,orderId);
    }

    @Override
    public OrderDTO cancelOne(String openid, String orderId) {
        OrderDTO orderDTO =checkOrderOwner(openid,orderId);
        if (orderDTO==null){
            throw new SellException(ResultEnum.ORDER_NO_EXIST);
        }
        return orderService.cancel(orderDTO);
    }



    private OrderDTO checkOrderOwner(String openId,String orderId){

        OrderDTO orderDTO=orderService.findOne(orderId);
        if(orderDTO==null){
            return null;
        }

        if(!orderDTO.getBuyerOpenid().equals(openId)){
            throw  new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
