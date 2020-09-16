package com.example.api.feign;

import com.alibaba.fastjson.JSON;
import com.example.api.bo.ProductDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("product-module")
public interface ProductFeign {

    @RequestMapping("/productDetail")
    String productDetail(String productId);

    @RequestMapping("/productPost")
    String productPost(ProductDetail detail);

    @GetMapping("/productList")
    String productList(String productId);

    @PostMapping("/productPrototype")
    String productPrototype(ProductDetail detail);

    @RequestMapping("/productRegion")
    String productRegion(String productId);

}
