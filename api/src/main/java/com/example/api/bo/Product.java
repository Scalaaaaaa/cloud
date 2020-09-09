package com.example.api.bo;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;

@Document(indexName = "test" ,type = "product")
public class Product implements Serializable {
    @Id
    private Long id;

    // 需要分词的字段
    @Field(type= FieldType.Text)
    private String name;

    // 无需分词的字段
    @Field(type= FieldType.Keyword)
    private String owner;

    private BigDecimal price;

    public Product(Long id, String name, String owner, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.price = price;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
