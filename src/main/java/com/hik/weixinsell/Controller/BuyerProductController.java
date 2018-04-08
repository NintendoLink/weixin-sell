package com.hik.weixinsell.Controller;

import com.hik.weixinsell.VO.ProductInfoVO;
import com.hik.weixinsell.VO.ProductVO;
import com.hik.weixinsell.VO.ResultVO;
import com.hik.weixinsell.dataobject.ProductCategory;
import com.hik.weixinsell.dataobject.ProductInfo;
import com.hik.weixinsell.service.CategoryService;
import com.hik.weixinsell.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BuyerProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/list")
    public ResultVO list(){
        //1.查询所有的上架商品
        List<ProductInfo>productInfoList=productService.findUpAll();

        //2.查询类目(一次性商品)
        List<Integer> categoryTypeList=new ArrayList<>();
        //传统方法
        for(ProductInfo p:productInfoList){
            categoryTypeList.add(p.getCategoryType());
        }

        //精简做法(jdk8特性)
//        List<Integer> categoryTypeList=productInfoList.stream().map(e->e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> result=categoryService.findByCategoryTypeIn(categoryTypeList);
        //3.数据拼装

        List<ProductVO> productVOList=new ArrayList<>();
        for(ProductCategory productCategory:result){
            System.out.println("********");
            ProductVO productVO=new ProductVO();
            productVO.setCateGory(productCategory.getCategoryName());
            productVO.setType(productCategory.getCategoryType());

//            List<ProductInfo> productInfos=new ArrayList<>();
            List<ProductInfoVO> productInfoVOList=new ArrayList<>();
            for (ProductInfo productInfo:productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO=new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
                productVO.setProductInfoVOList(productInfoVOList);

            }
            productVOList.add(productVO);
        }

        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");

//        ProductVO productVO=new ProductVO();
//        ProductInfoVO productInfoVO=new ProductInfoVO();
//        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));

//        resultVO.setData(Arrays.asList(productVO));
//        resultVO.setData(productVO);
        resultVO.setData(productVOList);
//        ProductInfoVO productInfoVO=new ProductInfoVO();
//        resultVO.setData(productInfoVO);
        return resultVO;
    }
}
