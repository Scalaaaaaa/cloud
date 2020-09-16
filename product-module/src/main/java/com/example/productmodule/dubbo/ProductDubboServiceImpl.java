package com.example.productmodule.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.example.bo.ProductBusiBo;
import com.example.service.ProductDubboService;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

// 暴露为dubbo服务
@Service
@Slf4j
public class ProductDubboServiceImpl implements ProductDubboService {
    @Override
    public List<ProductBusiBo> getProductList(ProductBusiBo param) {
        log.info("dubboParams="+ JSON.toJSONString(param));
        ProductBusiBo bo = new ProductBusiBo();
        bo.setName("name");
        bo.setPrice(new BigDecimal(5.55).setScale(2, RoundingMode.CEILING));
        bo.setTitle("title");
        ProductBusiBo bo1 = new ProductBusiBo();
        bo1.setName("name");
        bo1.setPrice(new BigDecimal(5.55).setScale(2,RoundingMode.CEILING));
        bo1.setTitle("title");
        List<ProductBusiBo> busiBoList = new ArrayList<>(2);
        busiBoList.add(bo);
        busiBoList.add(bo1);
        log.info("dubboResult="+ JSON.toJSONString(busiBoList));
        return busiBoList;
    }
}
