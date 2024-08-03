package com.hueged.hashedin.Order.Service.Feign;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private Long phoneNo;
	private String publicUserId;
	private String password;
	private String encryptedPassword;
	private Boolean isactive;
//	private List<RolesDto> userRoles;

	public UserDto (String firstName, String email ) {
		this.firstName=firstName;
		this.email=email;
	}

}
