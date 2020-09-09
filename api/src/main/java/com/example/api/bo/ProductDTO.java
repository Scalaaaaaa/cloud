package com.example.api.bo;

import java.math.BigDecimal;

public class ProductDTO {
    private Long id;

    private String name;

    private String owner;

    private BigDecimal price;

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

    public ProductDTO(Long id, String name, String owner, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.price = price;
    }

    public ProductDTO() {
    }
}
