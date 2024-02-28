package com.bookstore.gandhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bookstore.gandhi.models.Order;
import com.bookstore.gandhi.service.OrderService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/orders/")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping("{id}")
	public ResponseEntity<Order> getBookById(@PathVariable Integer id){
		return orderService.findOrderById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build()); //Método para regresar info si el id ingresado no existe o si
	}
	
	//post
	@PostMapping
	public Order createOrder (@RequestBody Order order) {
		return orderService.saveOrder(order);
	}
	//put
	//delete
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable Integer id){
		return orderService.findOrderById(id)
				.map(order-> {
					orderService.deleteOrder(order.getId());
					return ResponseEntity.ok().<Void>build();
					})
					.orElse(ResponseEntity.notFound().build());
	}
}
