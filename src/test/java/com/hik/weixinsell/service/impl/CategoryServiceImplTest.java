package com.hik.weixinsell.service.impl;

import com.hik.weixinsell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
    @Autowired
    private CategoryServiceImpl categoryService;
    @Test
    public void findOne() throws Exception {
        ProductCategory productCategory=categoryService.findOne(1);
        Assert.assertNotEquals(0,productCategory);
    }

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> result =categoryService.findAll();
        Assert.assertNotEquals(null,result);
    }

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<Integer> list= Arrays.asList(1,2);
        List<ProductCategory>result=categoryService.findByCategoryTypeIn(list);
        Assert.assertNotEquals(null,result);
    }

    @Test
    public void save() throws Exception {
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryType(5);
        productCategory.setCategoryId(5);
        productCategory.setCategoryName("hjhkj");

        ProductCategory result=categoryService.save(productCategory);

        Assert.assertNotEquals(null,result);
    }

}