package com.bruel.dscommerce.dtos;


import com.bruel.dscommerce.entities.Product;

public class ProductDTO {
    private Long id;
    private String name;
    private String descr;
    private Double price;
    private String imgUrl;

    public ProductDTO(){}

    public ProductDTO(Product product) {
        id = product.getId();
        name = product.getName();
        descr = product.getDesc();
        price = product.getPrice();
        imgUrl = product.getImgUrl();
    }

    //DTOs geralmente não têm setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescr() {
        return descr;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
