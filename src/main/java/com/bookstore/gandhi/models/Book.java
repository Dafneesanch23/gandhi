package com.bookstore.gandhi.models;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/*  public class Book {
	private int id; por encapsulación se trabaja con atributos privados
	private String name;
	private String author;
	private int stock;
	private double price;
	*/
	
	@Entity
	@Table( name = "book")
	public class Book {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "book_id")
		private int id;
		
		@Column(name = "name", nullable = false, length = 150)
		private String name;
		
		@Column(name = "author", nullable = false, length = 150)
		private String author;
		
		@Column(name = "stock", nullable = false)
		private int stock;
		
		@Column(name = "price", nullable = false)
		private double price;
		
		@OneToMany(mappedBy = "book")
		private Set<OrderDetails> orderDetail;
		
		//Tambien se puede utilizar este tipo de constructor en bases de datos
		public Book () {
			//constructos vacío o default
		}
		
		//Constructor sin el id ya que se genera automaticamente en la base de datos
		public Book( String name, String author, int stock, double price) {
			this.name = name;
			this.author = author;
			this.stock = stock;
			this.price = price;
		}
		
		public Book(int id, String name, String author, int stock, double price) {
			super();
			this.id = id;
			this.name = name;
			this.author = author;
			this.stock = stock;
			this.price = price;
		}
		
		//Getters y Setters
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}
		
	}
	
