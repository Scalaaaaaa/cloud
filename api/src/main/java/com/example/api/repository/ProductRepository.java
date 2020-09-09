package com.example.api.repository;

import com.example.api.bo.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductRepository extends ElasticsearchRepository<Product,Long> {

    Page<Product> findByOwnerEquals(String owner, Pageable page);
    List<Product> findByOwnerEquals(String owner);



}
