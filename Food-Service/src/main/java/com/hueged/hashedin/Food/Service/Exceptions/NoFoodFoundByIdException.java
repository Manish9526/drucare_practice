package com.hueged.hashedin.Food.Service.Exceptions;

public class NoFoodFoundByIdException extends RuntimeException{

	public NoFoodFoundByIdException(String message) {
		super(message);
	}
}
