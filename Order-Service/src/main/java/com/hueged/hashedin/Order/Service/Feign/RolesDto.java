package com.hueged.hashedin.Order.Service.Feign;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RolesDto {

	private Long id;
	private String roleName;
	private List<UserAuthorityDto> authorities;
}
