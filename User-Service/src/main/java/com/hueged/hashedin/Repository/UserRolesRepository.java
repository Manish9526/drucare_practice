package com.hueged.hashedin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hueged.hashedin.Model.UserRoles;

public interface UserRolesRepository extends JpaRepository<UserRoles, Long>{

	UserRoles findByRoleName(String roleName);

}
