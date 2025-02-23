package com.bruel.dscommerce.services;

import com.bruel.dscommerce.dtos.OrderDTO;
import com.bruel.dscommerce.entities.Order;
import com.bruel.dscommerce.repositories.OrderRepository;
import com.bruel.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Order result = orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(result);
    }
}
