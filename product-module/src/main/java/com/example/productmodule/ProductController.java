package com.example.productmodule;

import com.alibaba.fastjson.JSON;
import com.example.productmodule.bo.ProductDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductController {

    @RequestMapping("/productDetail")
    public String productDetail(String productId){
        log.info("in productModule");
        return "detail";
    }

    @RequestMapping("/productPost")
    public String productPost(ProductDetail detail){
        log.info("param==="+ JSON.toJSONString(detail));
        log.info("in productModule");
        return "detail";
    }

    @GetMapping("/productList")
    public String productList(String productId){
        log.info("in productModule");
        return "detail";
    }

    @PostMapping("/productPrototype")
    public String productPrototype(ProductDetail detail){
        log.info("param==="+ JSON.toJSONString(detail));
        log.info("in productModule");
        return "detail";
    }

    @RequestMapping("/productRegion")
    public String productRegion(String productId){
        log.info("in productModule");
        return "detail";
    }
}
