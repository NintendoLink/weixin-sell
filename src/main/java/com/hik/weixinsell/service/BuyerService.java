package com.hik.weixinsell.service;

import com.hik.weixinsell.DTO.OrderDTO;

public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openId,String orderId);
    //取消订单
    OrderDTO cancelOne(String openid,String orderId);

}
