package com.hik.weixinsell.Repository;

import com.hik.weixinsell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PruductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository pruductInfoRepository;

    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> result=pruductInfoRepository.findByProductStatus(0);
        System.out.println(result);
    }

    @Test
    public void findOne(){
        ProductInfo productInfo=pruductInfoRepository.findOne("1");
        System.out.println(productInfo);
    }

    @Test
    public void findAllTest(){
        List<ProductInfo> result=pruductInfoRepository.findAll();
        Assert.assertNotEquals(null,result);
        System.out.println(result);
    }

}