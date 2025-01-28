package com.bruel.dscommerce.repositories;

import com.bruel.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//repositórios são sempre interfaces
public interface ProductRepository extends JpaRepository<Product, Long> {
}
