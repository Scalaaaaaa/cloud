package com.example.service;

import com.example.bo.ProductBusiBo;

import java.util.List;

public interface ProductDubboService {

    List<ProductBusiBo> getProductList(ProductBusiBo param);
}
