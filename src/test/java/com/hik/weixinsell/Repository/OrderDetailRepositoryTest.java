package com.hik.weixinsell.Repository;

import com.hik.weixinsell.dataobject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("1");
        orderDetail.setOrderId("123");
        orderDetail.setProductIcon("");
        orderDetail.setProductId("123");
        orderDetail.setProductName("苹果");
        orderDetail.setProductPrice(new BigDecimal(123));
        orderDetail.setProductQuantity(12);
        repository.save(orderDetail);

    }
    @Test
    public void findByOrderId() throws Exception{
        List<OrderDetail> list=repository.findByOrderId("123");
        System.out.println(list);
    }
}