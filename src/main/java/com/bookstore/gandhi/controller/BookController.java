package com.bookstore.gandhi.controller;

import java.util.List;

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
import com.bookstore.gandhi.models.Book;
import com.bookstore.gandhi.service.BookService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/books/")
public class BookController {
	@Autowired
	private BookService bookService;
	
	//get
	@GetMapping
	public List<Book> getAllBooks(){
		return bookService.findAllBooks();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Book> getBookById(@PathVariable Integer id){
		return bookService.findBookById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build()); //Método para regresar info si el id ingresado no existe o si
	}
	//post
	@PostMapping
	public Book createBook (@RequestBody Book book) {
		return bookService.saveBook(book);
	}
	//put
	//delete
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Integer id){
		return bookService.findBookById(id)
				.map(book-> {
					bookService.deleteBook(book.getId());
					return ResponseEntity.ok().<Void>build();
					})
					.orElse(ResponseEntity.notFound().build());
	}
}
