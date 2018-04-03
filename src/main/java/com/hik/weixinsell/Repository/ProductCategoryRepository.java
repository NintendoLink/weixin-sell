package com.hik.weixinsell.Repository;

import com.hik.weixinsell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    /**
     * findBy***固定写法
     * @param dategoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> dategoryTypeList);
}
