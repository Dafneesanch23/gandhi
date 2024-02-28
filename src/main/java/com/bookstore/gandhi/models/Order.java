package com.bookstore.gandhi.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "order")

public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int id;
	
	
	//------------------------Relationships
	@ManyToOne
	@JoinColumn(name = "user_id" , nullable = false)
	private User user; // Entidad a la que se conecta
	
	@OneToMany(mappedBy = "order")
	private Set<OrderDetails> orderDetail;
	
	//Constructor vacío
	public Order() {		
	}

	//constructor normal
	public Order(int id, User user) {
		super();
		this.id = id;
		this.user = user;
	}
	
	//Getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	

}
