package com.hik.weixinsell.converter;

import com.hik.weixinsell.DTO.OrderDTO;
import com.hik.weixinsell.dataobject.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderMaster2OrderDTOConverter {

    public static OrderDTO converter(OrderMaster orderMaster){
        OrderDTO orderDTO=new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> converter(List<OrderMaster>orderMasterList){
        List<OrderDTO> orderDTOList=new ArrayList<>();
        for (OrderMaster orderMaster:orderMasterList){
            orderDTOList.add(converter(orderMaster));
        }
        return orderDTOList;
    }
}
