package com.bruel.dscommerce.repositories;

import com.bruel.dscommerce.entities.Order;
import com.bruel.dscommerce.entities.OrderItem;
import com.bruel.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
