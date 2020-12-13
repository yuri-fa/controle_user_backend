package com.recrutamento.Desafio.resouces;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recrutamento.Desafio.dto.UserDTO;
import com.recrutamento.Desafio.model.User;
import com.recrutamento.Desafio.service.UserService;

@RestController
@RequestMapping("/api")
public class UserResource {
	
	@Autowired
	UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<User>> findAll(){
		return ResponseEntity.ok().body(userService.findAll());
	}
	
	@PostMapping("/users")
	public ResponseEntity<Void> saveUser(@RequestBody UserDTO userDTO){
		userService.saveUser(userDTO);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id){
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable String id,@RequestBody UserDTO userDTO){
		User user = userService.fromDTO(userDTO);
		return ResponseEntity.ok().body(userService.updateUser(id,user));
	}
}
