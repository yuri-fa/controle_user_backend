package com.recrutamento.Desafio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.recrutamento.Desafio.model.User;

public interface UserRepository extends MongoRepository<User,String>{

	public List<User> findAll();
	
	public Optional<User> findByEmail(String email);
}
