package com.bruel.dscommerce.services;

import com.bruel.dscommerce.dtos.OrderDTO;
import com.bruel.dscommerce.dtos.OrderItemDTO;
import com.bruel.dscommerce.entities.Order;
import com.bruel.dscommerce.entities.OrderItem;
import com.bruel.dscommerce.entities.Product;
import com.bruel.dscommerce.entities.User;
import com.bruel.dscommerce.enums.OrderStatus;
import com.bruel.dscommerce.repositories.OrderItemRepository;
import com.bruel.dscommerce.repositories.OrderRepository;
import com.bruel.dscommerce.repositories.ProductRepository;
import com.bruel.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    AuthService authService;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Order result = orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        authService.validateSelfOrAdmin(result.getClient().getId());
        return new OrderDTO(result);
    }

    @Transactional
    public OrderDTO insert( OrderDTO orderDTO) {
        Order order = new Order();

        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);

        User user = userService.authenticated();
        order.setClient(user);

        for(OrderItemDTO itemDTO : orderDTO.getItems()){
            Product product = productRepository.getReferenceById(itemDTO.getProductId());
            OrderItem item = new OrderItem(order, product, itemDTO.getQuantity(), product.getPrice());
            order.getItems().add(item);
        }
        orderRepository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDTO(order);
    }
}
