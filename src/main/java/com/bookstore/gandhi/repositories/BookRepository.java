package com.bookstore.gandhi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.gandhi.models.Book;

@Repository
	public interface BookRepository extends JpaRepository<Book, Integer>{
		Optional <Book> findBookByPrice(double price);
	}


