package com.hueged.hashedin.Repository;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hueged.hashedin.Model.Users;
import com.hueged.hashedin.Model.UserDto;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

	Users findByEmail(String email);

	Users findByPublicUserId(String userId);

	Users findById(Integer userId);
	

}
