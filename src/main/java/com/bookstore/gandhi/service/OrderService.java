package com.bookstore.gandhi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bookstore.gandhi.models.Order;
import com.bookstore.gandhi.repositories.OrderRepository;

@Service
public class OrderService {
	private OrderRepository orderRepository;
	//get
	public Optional <Order> findOrderById(Integer id){
		return orderRepository.findById(id);
	}
	//post
	public Order saveOrder (Order order) {
		return orderRepository.save(order);
	}
	//put
	
	//delete
	public void deleteOrder(Integer id) {
		orderRepository.deleteById(id);
	}
}
