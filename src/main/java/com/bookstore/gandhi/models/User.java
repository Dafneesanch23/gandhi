package com.bookstore.gandhi.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")


public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	
	@Column (name = "username", nullable = false, length = 40, unique = true)
	private String username;
	
	@Column (name = "password", nullable = false, length = 40, unique = true)
	private String password;
	
	//------------------------Relationships
	@OneToMany(mappedBy = "user")
	private Set<Order> orders = new HashSet<>(); // Es una colección ya que un usuario puede hacer multiples ordenes 
	
	//Constructor vacío
	public User() {
		
	}
	
	public User(String username) {
		this.username = username;
	}
	
	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	

	
	
	
	
}
