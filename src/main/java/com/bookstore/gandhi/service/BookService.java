package com.bookstore.gandhi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.gandhi.models.Book;
import com.bookstore.gandhi.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	//get
	public List<Book> findAllBooks(){
		return bookRepository.findAll();
	}
	
	public Optional <Book> findBookById (Integer id){
		return bookRepository.findById(id); //Para evitar el error se puede castear (long) se coloca esto
	}
	//post
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}
	//put
	//delete
	public void deleteBook(Integer id) {
		bookRepository.deleteById(id);
	}

}
