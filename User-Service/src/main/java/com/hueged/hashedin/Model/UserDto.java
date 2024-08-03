package com.hueged.hashedin.Model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
	private List<RolesDto> userRoles;
	
	

}
