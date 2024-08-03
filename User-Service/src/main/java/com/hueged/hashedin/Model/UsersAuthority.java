package com.hueged.hashedin.Model;

import java.util.Collection;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UsersAuthority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String authorityName;
	
	@ManyToMany(mappedBy = "usersAuthority")
	private Collection<UserRoles> userRoles;
	
	public UsersAuthority(String authorityName) {
		super();
		this.authorityName = authorityName;
	}
	
}
