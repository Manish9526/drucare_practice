//package com.hueged.hashedin;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.UUID;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import com.hueged.hashedin.Model.Users;
//import com.hueged.hashedin.Model.UserRoles;
//import com.hueged.hashedin.Model.UsersAuthority;
//import com.hueged.hashedin.Repository.AuthorityRepository;
//import com.hueged.hashedin.Repository.UserRepository;
//import com.hueged.hashedin.Repository.UserRolesRepository;
//
//import jakarta.transaction.Transactional;
//
//@Component
//public class InitialUsersSetup<UsersRoles, UsersDeatils> {
//	
//	@Autowired
//	AuthorityRepository authorityRepository;
//	
//	@Autowired
//	UserRolesRepository rolesRepository;
//	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//	
//	@Autowired
//	private UserRepository usersRepository;
//	
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	@Transactional
//	@EventListener
//	public void onApplicationEvent(ApplicationReadyEvent event) {
//		this.logger.info("From application ready event...");
//		UsersAuthority readAuthority = createAuthority("READ");
//		UsersAuthority writeAuthority = createAuthority("WRITE");
//		UsersAuthority deleteAuthority = createAuthority("DELETE");
//
//		createRole("ROLE_USER", Arrays.asList(readAuthority, writeAuthority));
//		
//		UserRoles roleAdmin = createRole("ROLE_ADMIN", Arrays.asList(readAuthority, writeAuthority, deleteAuthority));
//		if (roleAdmin == null)
//			return;
//		
//		
//		Users users= new Users();
//		users.setPublicUserId(UUID.randomUUID().toString());
//		users.setFirstName("Manish");
//		users.setLastName("Ghalme");
//		users.setPhoneNo(7219232301l);
//
//		users.setPassword(this.bCryptPasswordEncoder.encode("1234"));
//		users.setUserRoles(Arrays.asList(roleAdmin));
//		users.setEmail("manish1234@gmail.com");
//		Users storedAdminUser = this.usersRepository.findByEmail("manish1234@gmail.com");
//		if (storedAdminUser == null) {
//			this.usersRepository.save(users);
//		}
//	}
//	
//	@Transactional
//	private UsersAuthority createAuthority(String authorityName) {
//		UsersAuthority authorityEntity = this.authorityRepository.findByAuthorityName(authorityName);
//		if (authorityEntity == null) {
//			authorityEntity = new UsersAuthority(authorityName);
//			this.authorityRepository.save(authorityEntity);
//		}
//		return authorityEntity;
//	}
//	
//	@Transactional
//	private UserRoles createRole(String roleName, Collection<UsersAuthority> authorities) {
//		UserRoles roleEntity = this.rolesRepository.findByRoleName(roleName);
//		if(roleEntity == null) {
//			roleEntity = new UserRoles(roleName,authorities);
//			this.rolesRepository.save(roleEntity);
//		}
//		return roleEntity;
//	}
//	
//	
//	
//}
