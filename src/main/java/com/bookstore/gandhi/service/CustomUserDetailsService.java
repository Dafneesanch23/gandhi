package com.bookstore.gandhi.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.bookstore.gandhi.models.User;
import com.bookstore.gandhi.repositories.UserRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	

	@Override //Método implementado automaticamente al hacer hover en la clase
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException ("Username not found"));
		return org.springframework.security.core.userdetails.User
				.withUsername(user.getUsername())
				.password(user.getPassword())
				.authorities(new ArrayList<>())
				.accountExpired(false)
				.credentialsExpired(false)
				.disabled(false)
				.build();
	}

}
