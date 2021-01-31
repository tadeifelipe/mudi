package com.tadeifelipe.mudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tadeifelipe.mudi.model.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	User findByUsername(String username);
}
