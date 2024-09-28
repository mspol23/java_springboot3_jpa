package com.learning.spring_project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.spring_project.entities.Order;
import com.learning.spring_project.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
	
	public Order findById(Long id){
		return orderRepository.findById(id).get();
	}
	
}
