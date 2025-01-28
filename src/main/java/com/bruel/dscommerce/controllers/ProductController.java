package com.bruel.dscommerce.controllers;

import com.bruel.dscommerce.dtos.ProductDTO;
import com.bruel.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

//o que for implentado por essa classe vai responder pela web
@RestController
//configuração da rota
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    //indica o verbo da requisição
    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id){
        //os metódos por padrão retornam um Optional em caso de ero
        return productService.findById(id);

    }
}
