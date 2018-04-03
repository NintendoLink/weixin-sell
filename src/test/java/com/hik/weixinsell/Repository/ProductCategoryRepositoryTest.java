package com.hik.weixinsell.Repository;

import com.hik.weixinsell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository productCategoryReposority;

//    @Test
//        public void findOneTest(){
//        ProductCategory productCategory=productCategoryReposority.findOne(1);
//        System.out.println(productCategory.toString());
//    }

    @Test
        public void saveTest(){
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryId(1);
        productCategory.setCategoryType(1);
        productCategory.setCategoryName("hehe");

        productCategoryReposority.save(productCategory);
    }
}