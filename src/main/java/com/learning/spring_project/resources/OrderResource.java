package com.learning.spring_project.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.spring_project.entities.Order;
import com.learning.spring_project.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService orderService;
	
	public ResponseEntity<List<Order>> findAll(){
		List<Order> objList = orderService.findAll();
		return ResponseEntity.ok().body(objList);
	}
	
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = orderService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
