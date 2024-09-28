package com.learning.spring_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.spring_project.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
