package com.bookstore.gandhi.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.bookstore.gandhi.models.User;
import com.bookstore.gandhi.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	
	//get
	public Optional <User> findUserById(Integer id){
		return userRepository.findById(id);
	}
	
	//post
	public User saveUser(User user) {
		return userRepository.save(user);

	}
	//put
	
	//delete
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}

}
