package com.hik.weixinsell.service.impl;

import com.hik.weixinsell.DTO.OrderDTO;
import com.hik.weixinsell.dataobject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

    private final String ORDERID="1523254890442755433";

    @Test
    public void findListTest(){

    }
    @Test
    public void findOnetest(){


        OrderDTO orderDTO= orderService.findOne(ORDERID);
        System.out.println(orderDTO);
    }

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
    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}