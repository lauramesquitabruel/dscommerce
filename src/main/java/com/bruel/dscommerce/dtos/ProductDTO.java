package com.bruel.dscommerce.dtos;


import com.bruel.dscommerce.entities.Category;
import com.bruel.dscommerce.entities.Product;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

//as validações dos dados são nos DTOs
public class ProductDTO {
    private Long id;
    @Size(min = 3, max = 80, message = "Nome precisa ter entre 3 e 80 caracteres")
    @NotBlank(message = "Campo requerido")
    private String name;
    @Size(min = 10, message = "Descrição precisa ter no mínimo 10 caracteres")
    private String descr;
    @NotNull(message = "Campo requirido")
    @Positive(message = "Preço precisa ser positivo")
    private Double price;
    private String imgUrl;

    @NotEmpty(message = "Deve ter no mínimo uma categoria")
    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO(){}

    public ProductDTO(Product product) {
        id = product.getId();
        name = product.getName();
        descr = product.getDesc();
        price = product.getPrice();
        imgUrl = product.getImgUrl();
        for (Category cat : product.getCategories()){
            categories.add(new CategoryDTO(cat));
        }
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

    public List<CategoryDTO> getCategories() {
        return categories;
    }
}
