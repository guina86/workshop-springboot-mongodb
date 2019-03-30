package com.leandroguina.workshopmongo.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandroguina.workshopmongo.domain.User;
import com.leandroguina.workshopmongo.repository.UserRepository;
import com.leandroguina.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		User user;
		try {
			user = repo.findById(id).get();

		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Object not found");
		}
		return user;

	}

}
