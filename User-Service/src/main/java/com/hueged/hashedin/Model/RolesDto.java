package com.hueged.hashedin.Model;

import java.util.List;

import lombok.Data;

@Data
public class RolesDto {

	private Long id;
	private String roleName;
	private List<UserAuthorityDto> authorities;
}
