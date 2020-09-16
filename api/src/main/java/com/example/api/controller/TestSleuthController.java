package com.example.api.controller;

import com.alibaba.fastjson.JSON;
import com.example.api.bo.ProductDetail;
import com.example.api.feign.ProductFeign;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.GenericFilterBean;

@RestController
@Slf4j
public class TestSleuthController{
    @Autowired
    private ProductFeign productFeign;

    GenericFilterBean tracer;
    @RequestMapping("/productDetail")
    public String productDetail(String productId){
        String traceid = MDC.get("X-B3-TraceId");
        log.info("in apiModule param="+productId+",traceId="+traceid);
        return productFeign.productDetail(productId);
    }

    @RequestMapping("/productPost")
    public String productPost(ProductDetail detail){
        log.info("apiParam==="+ JSON.toJSONString(detail));
        log.info("in apiModule");
        return productFeign.productPost(detail);
    }

    @GetMapping("/productList")
    public String productList(String productId){
        log.info("in apiModule param="+productId);
        return productFeign.productList(productId);
    }

    @RequestMapping("/productPrototype")
    public String productPrototype(ProductDetail detail){
        log.info("apiParam==="+ JSON.toJSONString(detail));
        log.info("in apiModule");
        return productFeign.productPrototype(detail);
    }

    @RequestMapping("/productRegion")
    public String productRegion(String productId){
        log.info("in apiModule param="+productId);
        return productFeign.productRegion(productId);
    }
}
