package com.hik.weixinsell.Repository;

import com.hik.weixinsell.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PruductInfoRepositoryTest {
    @Autowired
    private PruductInfoRepository pruductInfoRepository;

    @Test
    public void findByProductStatus() throws Exception {
    }

    @Test
    public void findOne(){
//        ProductInfo productInfo=pruductInfoRepository.findOne("1");
//        System.out.println(productInfo.toString());
        ProductInfo productInfo=pruductInfoRepository.findOne("1");
        System.out.println(productInfo);
    }

}