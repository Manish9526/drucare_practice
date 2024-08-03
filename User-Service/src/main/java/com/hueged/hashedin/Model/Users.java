package com.hueged.hashedin.Model;

import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "user_details") 
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Users {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 50)
	private String firstName;
	
	@Column(nullable = false, length = 50)
	private String lastName;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(unique = true, length = 12)
	private Long phoneNo;
	
	@Column(nullable = false)
	private String Password;
	
	@Column(nullable = false, unique = true)
	private String publicUserId;
	
	@Column(nullable = false)
	private boolean isactive =true;
	
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns =@JoinColumn(name = "users_id", referencedColumnName = "id"),
			inverseJoinColumns =@JoinColumn(name = "roles_id", referencedColumnName = "id") )
	
	private Collection<UserRoles> userRoles;
	
}
