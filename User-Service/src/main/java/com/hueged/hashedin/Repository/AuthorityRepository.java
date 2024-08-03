package com.hueged.hashedin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hueged.hashedin.Model.UsersAuthority;

public interface AuthorityRepository extends JpaRepository<UsersAuthority, Long> {
	
	UsersAuthority findByAuthorityName(String authorityName);

}
