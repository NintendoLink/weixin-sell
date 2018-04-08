package com.hik.weixinsell.Repository;

import com.hik.weixinsell.dataobject.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void saveTest(){
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderId("123");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("1234567");
        orderMaster.setBuyerAddress("呵呵");
        orderMaster.setBuyerOpenid("110110");
        orderMaster.setOrderAmount(new BigDecimal(23));

        orderMasterRepository.save(orderMaster);
    }
    @Test
    public void findByBuyerOpenid() throws Exception {
    }

}