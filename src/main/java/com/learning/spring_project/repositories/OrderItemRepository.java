package com.learning.spring_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.spring_project.entities.OrderItem;
import com.learning.spring_project.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
