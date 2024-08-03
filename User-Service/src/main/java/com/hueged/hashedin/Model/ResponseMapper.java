package com.hueged.hashedin.Model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ResponseMapper {

	private Object data;
	private String code;
	private String message;
	
	private List<Validations> validation;
	public void addValidations(String code, String message) {
			this.validation.add(new Validations(code,message));
		
	}
	public ResponseMapper(String code, String message) {
		this.code = code;
		this.message = message;
		this.validation = new ArrayList<>();
	}
	


}
