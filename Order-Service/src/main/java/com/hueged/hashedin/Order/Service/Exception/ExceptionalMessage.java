package com.hueged.hashedin.Order.Service.Exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionalMessage {
	private String error;
	private LocalDateTime dateTime;
	private Boolean status;
}