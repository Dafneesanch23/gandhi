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
import com.bookstore.gandhi.models.User;
import com.bookstore.gandhi.service.UserService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping ("/api/users/")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id){
		return userService.findUserById(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public User createUser (@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	//put
	
	//delete
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
		return userService.findUserById(id)
				.map(user-> {
					userService.deleteUser(user.getId());
					return ResponseEntity.ok().<Void>build();
					})
					.orElse(ResponseEntity.notFound().build());
				
	}

}
