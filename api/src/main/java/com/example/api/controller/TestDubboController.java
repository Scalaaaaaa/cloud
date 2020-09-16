package com.example.api.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.bo.ProductBusiBo;
import com.example.service.ProductDubboService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dubbo")
public class TestDubboController {
    @Reference
    private ProductDubboService productDubboService;

    @RequestMapping("/productList")
    public List<ProductBusiBo> productBusiBoList(ProductBusiBo param){
        return productDubboService.getProductList(param);
    }

}
