package com.recrutamento.Desafio.exception;

public class UserDataNotFound extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UserDataNotFound(String message) {
		super(message);
	}
}
