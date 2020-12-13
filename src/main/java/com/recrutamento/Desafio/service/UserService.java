package com.recrutamento.Desafio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutamento.Desafio.dto.UserDTO;
import com.recrutamento.Desafio.exception.UserDataNotFound;
import com.recrutamento.Desafio.exception.UserExistException;
import com.recrutamento.Desafio.exception.UserNotFoundException;
import com.recrutamento.Desafio.model.User;
import com.recrutamento.Desafio.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public List<User> findAll(){
		return userRepository.findAll();
	}

	public void saveUser(UserDTO userDTO) {
		List<String> messagens = new ArrayList<>();
		if (userDTO.getNome().trim().equals("")) {
			messagens.add("Nome não informado");
		}
		if (userDTO.getEmail().trim().equals("")) {
			messagens.add("Email não informado");
		}
		
		Optional<User> oUser = userRepository.findByEmail(userDTO.getEmail());
		
		if (oUser.isPresent()) {
			throw new UserExistException("Email já esta vinculado a uma conta");
		}else if (messagens.size() > 0) {
			throw new UserDataNotFound(messagens.stream().collect(Collectors.joining(",")));
		}else {
			userRepository.save(new User(userDTO));
			
		}
	}

	public void deleteUser(String idUser) {
		userRepository.deleteById(idUser);
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO);
	}

	public User updateUser(String id ,final User user) {
		Optional<User> oUser = userRepository.findById(id);
		return oUser.map(userTemp -> userRepository.save(user)).orElseThrow(() -> new UserNotFoundException("Usuario não encontrado")) ;
	}
}
