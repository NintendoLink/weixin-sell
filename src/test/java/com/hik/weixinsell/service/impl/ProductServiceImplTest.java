package com.hik.weixinsell.service.impl;

import com.hik.weixinsell.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService;
    @Test
    public void findOne() throws Exception {
    }

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo>result =productService.findUpAll();
        System.out.println(result);
    }

    @Test
    /**
     * page
     */
    public void findAll() throws Exception {
        PageRequest pageRequest=new PageRequest(0,2);
        Page<ProductInfo> page=productService.findAll(pageRequest);
        System.out.println(page);
    }

    @Test
    public void save() throws Exception {
    }

}