package com.hik.weixinsell.service;

import com.hik.weixinsell.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {
    ProductCategory findOne(Integer category);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
