package com.hik.weixinsell.Repository;

import com.hik.weixinsell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository productCategoryReposority;

    @Test
        public void findOneTest(){
        ProductCategory productCategory=productCategoryReposority.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
        public void saveTest(){
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryId(1);
        productCategory.setCategoryType(1);
        productCategory.setCategoryName("hehe");

        /**
         * 断言
         */
        Assert.assertNotEquals(null,productCategory);

        productCategoryReposority.save(productCategory);
    }
    @Test
    public void updateTest(){
        ProductCategory productCategory=productCategoryReposority.findOne(1);
        productCategory.setCategoryType(10);
        productCategoryReposority.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer>list= Arrays.asList(1,2);
        List<ProductCategory> ProductCategoryList=productCategoryReposority.findByCategoryTypeIn(list);
        for (ProductCategory p: ProductCategoryList){
            System.out.println(p);

        }
        Assert.assertNotEquals(0,ProductCategoryList);
    }
}