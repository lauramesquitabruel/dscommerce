package com.bruel.dscommerce.dtos;

import com.bruel.dscommerce.entities.Product;
import jakarta.persistence.Column;

public class ProductMinDTO {
    private Long id;
    private String name;
    private Double price;
    private String imgUrl;

    public ProductMinDTO(){}

    public ProductMinDTO(Product product) {
        id = product.getId();
        name = product.getName();
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


    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
