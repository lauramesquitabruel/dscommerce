package com.bruel.dscommerce.services;

import com.bruel.dscommerce.dtos.ProductDTO;
import com.bruel.dscommerce.entities.Product;
import com.bruel.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    //o service retorna um DTO
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product result = productRepository.findById(id).get();
        return new ProductDTO(result);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> result = productRepository.findAll(pageable);
        return result.map(ProductDTO::new);
    }
}
