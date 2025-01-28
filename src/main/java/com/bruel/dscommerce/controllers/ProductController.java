package com.bruel.dscommerce.controllers;

import com.bruel.dscommerce.dtos.ProductDTO;
import com.bruel.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    //rota = /products?size=12&page=n&sort=atr
    @GetMapping()
    public Page<ProductDTO> findAll(Pageable pageable){
        return productService.findAll(pageable);

    }

    @PostMapping
    public ProductDTO insert(@RequestBody ProductDTO productDTO){
        return productService.insert(productDTO);
    }
}
