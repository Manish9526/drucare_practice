package com.hueged.hashedin.Order.Service.Feign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthorityDto {

	private Long id;
	private String authorityName;

}
