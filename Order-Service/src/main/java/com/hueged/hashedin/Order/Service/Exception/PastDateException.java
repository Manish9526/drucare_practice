package com.hueged.hashedin.Order.Service.Exception;

public class PastDateException extends RuntimeException {

	public PastDateException(String message) {
		super(message);
	}
}
