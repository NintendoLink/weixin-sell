package com.hik.weixinsell.service.impl;

import com.hik.weixinsell.DTO.CartDTO;
import com.hik.weixinsell.Repository.ProductInfoRepository;
import com.hik.weixinsell.dataobject.ProductInfo;
import com.hik.weixinsell.enums.ProductStatusEnum;
import com.hik.weixinsell.enums.ResultEnum;
import com.hik.weixinsell.exception.SellException;
import com.hik.weixinsell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoRepository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(0);
    }

    @Override
    /**
     * Page特殊对象
     */
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }


    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }


    /**
     *
     *
     * @param cartDTOList
     */
    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {

    }

    /**
     *
     * @param cartDTOList
     */
    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO:cartDTOList){
            ProductInfo productInfo=productInfoRepository.findOne(cartDTO.getProductId());
            if(productInfo==null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result=productInfo.getProductStock()-cartDTO.getProductQuantity();
            if(result<0){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }

    }
}
