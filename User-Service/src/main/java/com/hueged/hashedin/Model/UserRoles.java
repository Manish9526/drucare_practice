package com.hueged.hashedin.Model;

import java.util.Collection;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserRoles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String roleName;
	
	@ManyToMany(mappedBy = "userRoles")
	private Collection<Users> userDeatils;
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "roles_authorities", joinColumns =@JoinColumn(name = "role_id", referencedColumnName = "id"),
			inverseJoinColumns =@JoinColumn(name = "authorities_id", referencedColumnName = "id") )
	private Collection<UsersAuthority> usersAuthority;
	public UserRoles(String roleName, Collection<UsersAuthority> authorities) {
		super();
		this.roleName = roleName;
		this.usersAuthority = authorities;
	}
}
