package com.hueged.hashedin.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hueged.hashedin.Exceptions.UserAlreadyPresentException;
import com.hueged.hashedin.Model.UserDto;
import com.hueged.hashedin.Model.UserRoles;
import com.hueged.hashedin.Model.Users;
import com.hueged.hashedin.Model.UsersAuthority;
import com.hueged.hashedin.Repository.UserAuthorityRepository;
import com.hueged.hashedin.Repository.UserRepository;
import com.hueged.hashedin.Repository.UserRolesRepository;

import jakarta.transaction.Transactional;


@Service
public class UserServiceImpl implements UsersService{

	@Autowired
	UserAuthorityRepository userAuthorityRepository;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserRolesRepository userRolesRepository;
	
//	@Autowired
//	 BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserServiceImpl(UserRepository usersRepository) {
		this.userRepository = usersRepository;
//		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		
	}
	
	
	
	@Transactional
	private UsersAuthority createAuthority(String authorityName) {
		UsersAuthority authorityEntity =this.userAuthorityRepository.findByAuthorityName(authorityName);
		if (authorityEntity == null) {
			authorityEntity = new UsersAuthority(authorityName);
			this.userAuthorityRepository.save(authorityEntity);
		}
		return authorityEntity;
	}
	
	@Transactional
	private UserRoles createRole(String roleName, Collection<UsersAuthority> authorities) {
		UserRoles roleEntity = this.userRolesRepository.findByRoleName(roleName);
		if(roleEntity == null) {
			roleEntity = new UserRoles(roleName, authorities);
			userRolesRepository.save(roleEntity);
		}
		return roleEntity;
	}


	@Override
	public UserDto createUsers(Users userDeatils) {
		ModelMapper modelMapper = new ModelMapper();
		logger.info("checking the user with email"+ userDeatils.getEmail());
		Users userDto = this.userRepository.findByEmail(userDeatils.getEmail());
		
		if (userDto == null) {
			UserRoles userRole = new UserRoles();

				logger.info("Role creating UsersAuthority/role for User ");
				UsersAuthority readAuthority = createAuthority("READ");
				userRole = createRole("ROLE_USER", Arrays.asList(readAuthority));
				

			userDeatils.setPublicUserId(UUID.randomUUID().toString());
			userDeatils.setPassword(userDeatils.getPassword());
			userDeatils.setUserRoles(Arrays.asList(userRole));
			userDeatils = this.userRepository.save(userDeatils);
			logger.info("user created successfully");
		}else {
			logger.error("User is already present pls login Exception");
			throw new UserAlreadyPresentException("User is already present pls login");
			
		}
		return modelMapper.map(userDeatils, UserDto.class);
	}
	@Override
	public UserDto getOneUser(@Valid String userId) {
		ModelMapper modelMapper = new ModelMapper();
		logger.info("check the userId "+userId);
		Users userDeatilsObj=	userRepository.findByPublicUserId(userId);
		UserDto UserDto =modelMapper.map(userDeatilsObj, UserDto.class);
		return UserDto;
	}
	@Override
	public UserDto updateUserData(Integer userId, UserDto UserDto) {
		logger.info("check the userId "+userId);
		Users userDeatils=userRepository.findById(userId);
		if (userDeatils != null) {
			if (userDeatils.getFirstName() != null) {
				userDeatils.setFirstName(UserDto.getFirstName());
			}
			if (userDeatils.getLastName() != null) {
				userDeatils.setLastName(UserDto.getLastName());
			}
			if (userDeatils.getEmail() != null) {
				userDeatils.setEmail(UserDto.getEmail());
			}
			if (userDeatils.getPassword() != null) {
				userDeatils.setPassword(UserDto.getPassword());
			}
			if(userDeatils.getPhoneNo()!=null) {
				userDeatils.setPhoneNo(UserDto.getPhoneNo());
			}

		}
		 userRepository.save(userDeatils);
		return UserDto;
	}
	@Override
	public Boolean deleteUser(String userId) {

		Boolean flag = false;
		Users UserDeatils = userRepository.findByPublicUserId(userId);
		if (UserDeatils != null) {
			logger.info("deleting the user");
			UserDeatils.setIsactive(false);
			userRepository.save(UserDeatils);
			flag = true;
		}
		return flag;
		
	}



	@Override
	public UserDto getUserDetailsByEmail(String email) {
//		Users UserDeatils = userRepository.getUserDetailsByEmail(email);
		return null;
	}
	
	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Users users = userRepository.findByEmail(username);
//		if (users == null)
//			throw new UsernameNotFoundException(username);
//		
//		//The user class accepts roles and authorities as a collection of granted authority objects.
//		Collection<GrantedAuthority> authorities = new ArrayList<>();
//		Collection<UserRoles> roles = users.getUserRoles();
//		roles.forEach((role) -> {
//			authorities.add(new SimpleGrantedAuthority(role.getRoleName())); // gives list of roles
//			Collection<UsersAuthority> authorityEntities = role.getUsersAuthority();
//			authorityEntities.forEach((authorityEntity) -> {
//				logger.info("authorityEntity.getAuthorityName()");
//				authorities.add(new SimpleGrantedAuthority(authorityEntity.getAuthorityName()));
//			});
//		});
//		
//		
//		return  new User(users.getEmail(), 
//				users.getPassword(),
//				true, true, true,
//				true, authorities);
//	}
//
//	@Override
//	public UserDto getUserDetailsByEmail(String email) {
//		Users users = userRepository.findByEmail(email);
//		if (users == null)
//			throw new UsernameNotFoundException(email);
//		return new ModelMapper().map(users, UserDto.class);
//	}




}
