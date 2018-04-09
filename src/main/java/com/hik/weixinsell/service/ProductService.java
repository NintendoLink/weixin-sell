package com.hik.weixinsell.service;

import com.hik.weixinsell.DTO.CartDTO;
import com.hik.weixinsell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductInfo findOne(String productId);

    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);
    /**
     * 加库存
     */

    void increaseStock(List<CartDTO> cartDTOList);

    /**
     * 减库存
     */
    void decreaseStock(List<CartDTO> cartDTOList);
}
