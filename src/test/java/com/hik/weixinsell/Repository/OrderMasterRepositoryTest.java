package com.hik.weixinsell.Repository;

import com.hik.weixinsell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    private final String OPENID="110110";

    @Test
    public void saveTest(){
//        OrderMaster orderMaster=new OrderMaster();
//        orderMaster.setOrderId("123");
//        orderMaster.setBuyerName("师兄");
//        orderMaster.setBuyerPhone("1234567");
//        orderMaster.setBuyerAddress("呵呵");
//        orderMaster.setBuyerOpenid("110110");
//        orderMaster.setOrderAmount(new BigDecimal(23));
//
//        orderMasterRepository.save(orderMaster);

        OrderMaster orderMaster2=new OrderMaster();
        orderMaster2.setOrderId("124");
        orderMaster2.setBuyerName("师兄");
        orderMaster2.setBuyerPhone("1234567");
        orderMaster2.setBuyerAddress("呵呵");
        orderMaster2.setBuyerOpenid("110110");
        orderMaster2.setOrderAmount(new BigDecimal(23));

        orderMasterRepository.save(orderMaster2);
    }
    @Test
    public void findByBuyerOpenid() throws Exception {
        PageRequest pageRequest=new PageRequest(0,1);
        Page<OrderMaster> page=orderMasterRepository.findByBuyerOpenid(OPENID,pageRequest);
        System.out.println(page.getTotalElements()+"====>"+page.getTotalPages());
        Assert.assertNotEquals(0,page.getTotalElements());
    }

}