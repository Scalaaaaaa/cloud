package com.example.productmodule.bo;

public class ProductDetail {

    private String id;

    private String protoType;

    private String description;

    private String owner;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProtoType() {
        return protoType;
    }

    public void setProtoType(String protoType) {
        this.protoType = protoType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
