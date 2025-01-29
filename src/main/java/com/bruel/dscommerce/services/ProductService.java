package com.bruel.dscommerce.services;

import com.bruel.dscommerce.dtos.ProductDTO;
import com.bruel.dscommerce.entities.Product;
import com.bruel.dscommerce.repositories.ProductRepository;
import com.bruel.dscommerce.services.exceptions.DatabaseException;
import com.bruel.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    //o service retorna um DTO
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product result = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ProductDTO(result);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> result = productRepository.findAll(pageable);
        return result.map(ProductDTO::new);
    }

    @Transactional
    public ProductDTO insert(ProductDTO productDTO){
        //mapeia a requisição recebida para um novo produto
        Product product = new Product();
        copyDtoToEntity(productDTO, product);

        //salva a requisição no banco e obtem uma nova referência para ele
        product = productRepository.save(product);

        return new ProductDTO(product);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO productDTO){
        try{
            //prepara um objeto monitorado pelo JPA
            Product product = productRepository.getReferenceById(id);
            copyDtoToEntity(productDTO, product);
            //salva a requisição no banco e obtem uma nova referência para ele
            product = productRepository.save(product);

            return new ProductDTO(product);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }

    }

    //executa a transação se o metódo estiver no contexto de outra transação
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if(!productRepository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try{
            productRepository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException("Falha de integridade referencial");
        }

    }

    private void copyDtoToEntity(ProductDTO productDTO, Product entity){
        entity.setName(productDTO.getName());
        entity.setDesc(productDTO.getDescr());
        entity.setPrice(productDTO.getPrice());
        entity.setImgUrl(productDTO.getImgUrl());
    }
}
