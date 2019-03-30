package com.leandroguina.workshopmongo.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandroguina.workshopmongo.domain.User;
import com.leandroguina.workshopmongo.dto.UserDTO;
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

		try {
			User user = repo.findById(id).get();
			return user;
		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Object not found");
		}
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

}
