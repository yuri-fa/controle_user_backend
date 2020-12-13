package com.recrutamento.Desafio.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.recrutamento.Desafio.dto.UserDTO;

@Document(collection="User")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String nome;
	private String email;
	
	public User() {
		super();
	}
	
	
	public User(String id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public User(UserDTO userDTO) {
		this.nome = userDTO.getNome();
		this.email = userDTO.getEmail();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
