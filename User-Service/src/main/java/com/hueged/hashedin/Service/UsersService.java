package com.hueged.hashedin.Service;
import com.hueged.hashedin.Model.UserDto;
import com.hueged.hashedin.Model.Users;

public interface UsersService  {

	UserDto getUserDetailsByEmail(String email);
	
	UserDto createUsers(Users userDeatils);

	UserDto getOneUser(  String userId);

	UserDto updateUserData(Integer userId, UserDto userDto);

	Boolean deleteUser(String userId);

	

}
