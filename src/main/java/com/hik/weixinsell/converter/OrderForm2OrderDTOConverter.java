package com.hik.weixinsell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hik.weixinsell.DTO.OrderDTO;
import com.hik.weixinsell.dataobject.OrderDetail;
import com.hik.weixinsell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public class OrderForm2OrderDTOConverter {


    public static OrderDTO converter(OrderForm orderForm)  {
        Gson gson=new Gson();
        OrderDTO orderDTO=new OrderDTO();

        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        List<OrderDetail> orderDetailList=new ArrayList<>();
        try {
            orderDetailList=gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (Exception e){
            System.out.println("对象转换出错");
//            throw new SellException(ResultEnum.PARAM_ERROR);
        }


        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
