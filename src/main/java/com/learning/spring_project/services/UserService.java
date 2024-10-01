package com.learning.spring_project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.spring_project.entities.User;
import com.learning.spring_project.repositories.UserRepository;
import com.learning.spring_project.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User newUser) {
		return userRepository.save(newUser);
	}
	
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = userRepository.getReferenceById(id);
		updateData(entity, obj);
		return userRepository.save(entity);
	}
	
	public void updateData(User entity, User obj) {
		if (obj.getName() != null) {
			entity.setName(obj.getName());
		}

		if (obj.getEmail() != null) {
			entity.setEmail(obj.getEmail());
		}

		if (obj.getPhone() != null) {
			entity.setPhone(obj.getPhone());
		}

		if (obj.getPassword() != null) {
			entity.setPassword(obj.getPassword());
		}
	}
}
