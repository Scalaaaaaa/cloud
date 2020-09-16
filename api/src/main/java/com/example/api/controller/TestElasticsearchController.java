package com.example.api.controller;

import com.alibaba.fastjson.JSON;
import com.example.api.bo.PageBo;
import com.example.api.bo.Product;
import com.example.api.bo.ProductDTO;
import com.example.api.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.queryparser.xml.builders.BooleanQueryBuilder;
import org.apache.lucene.search.Query;
import org.apache.tomcat.util.json.JSONParser;
import org.aspectj.lang.ProceedingJoinPoint;
import org.elasticsearch.common.io.stream.StreamOutput;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryShardContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@Slf4j
public class TestElasticsearchController {
    /*@Autowired
    ElasticsearchTemplate template;*/
    @Autowired
    ProductRepository repository;

    @Autowired
    ElasticsearchRestTemplate elasticsearchRestTemplate;

    @GetMapping("/hello")
    public String getRequest() {
        return "Hello World.";
    }

    @RequestMapping(value = "/product/index")
    public Product postProduct(Product product){
        log.info("params========="+JSON.toJSONString(product));
        // 经测试  index和save都一样，id存在则更新，否则新增
        // 新增时，自动创建索引
        repository.index(product);
        return product;
    }

    @RequestMapping(value = "/product/save")
    public Product postProduct1(Product product){
        log.info("params========="+JSON.toJSONString(product));
        repository.save(product);
        return product;
    }
    @RequestMapping(value = "/product/delete",method = RequestMethod.DELETE)
    public Product delete(Product product){
        log.info("params========="+JSON.toJSONString(product));
        repository.deleteById(product.getId());
        return product;
    }

    @RequestMapping(value = "/search")
    public List<Product> search(Product product, PageBo pageBo){
        // 分页查询注意： 页码是从0开始的。每页条数 正常含义，从1开始。
        // 分页查询 方法1
        BoolQueryBuilder qb = QueryBuilders.boolQuery();
        qb.must(QueryBuilders.termQuery("owner",product.getOwner()));
        Page<Product> products1 = repository.search(qb, pageBo);

        // 分页查询 方法2
        // Page<Product> products1 = repository.findByOwnerEquals(product.getOwner(), pageBo);
        List<Product> result = products1.getContent();
        log.info("products1 == "+JSON.toJSONString(products1));
        log.info("result == "+JSON.toJSONString(result));
        // 简单查询
        // List<Product> products = repository.findByOwnerEquals(product.getOwner());
        return result;
    }
    @PostMapping("/addProduct")
    @ResponseBody
    public Product addProduct(){
        Random random = new Random(1000);
        Product product = new Product(random.nextLong(),"jixiegeming code 01",
                "qinghuatongfang",new BigDecimal(5999));
        repository.save(product);
        return product;
    }
}
