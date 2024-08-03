package com.hueged.hashedin.Controller;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hueged.hashedin.Model.ResponseMapper;
import com.hueged.hashedin.Model.UserDto;
import com.hueged.hashedin.Model.Users;
import com.hueged.hashedin.Service.UsersService;
import com.hueged.hashedin.UserUtills.UserUtills;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/users")
@Tag(name = "users Management", description = "Handle operations related to Food Category")
public class UserController {
	
	@Autowired
	UsersService userService;
	
	@Autowired
	UserUtills userUtills;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@PostMapping("/createUser")
	@Operation(summary = "Create a User")
	@ApiResponse(responseCode = "200", description = " Data Inserted Successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseMapper.class)))
	public ResponseEntity<ResponseMapper> createUser ( @RequestBody @Valid Users userDeatils){
		logger.info("Creating the new user ");
		UserDto  userDeatilsObj = userService.createUsers(userDeatils);
		return userUtills.responseEntityForUserInsertSuccess(userDeatilsObj) ;
		
	}
	

	@GetMapping(path = "/{userId}")
	@Operation(summary = "Fetch User Detaile")
	@ApiResponse(responseCode = "200", description = "Fetch user detailes", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseMapper.class)))
	public ResponseEntity<ResponseMapper> getSingleUser( @PathVariable @Valid String userId){
	
		return userUtills.responseEntityForFetchSuccess( userService.getOneUser(userId));
	}

	@PutMapping(path = "/updateuser/{userId}")
	@Operation(summary = "Update User Detailes")
	@ApiResponse(responseCode = "200", description = "Update user detailes", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseMapper.class)))
	public ResponseEntity<ResponseMapper> updateUserData(@PathVariable Integer userId, @RequestBody UserDto userDto){
	
		return userUtills.responseEntityForUpdateSuccess(userService.updateUserData(userId, userDto));
	}
	
	@DeleteMapping(path = "/deleteuser/{userId}")
	@Operation(summary = "Delete User Detailes")
	@ApiResponse(responseCode = "200", description = "Delete user detailes", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseMapper.class)))
	public ResponseEntity<String> deleteUser(@PathVariable String userId){
		
	 Boolean flag =userService.deleteUser(userId);
	 logger.info("check the satatus of user deleted " +flag);

	 if(flag)
		return new ResponseEntity("User deleted successfully",HttpStatus.OK);
	 else
		return new ResponseEntity("Unable to deleted User",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/usermail/{mailId}")
	@Operation(summary = "Fetch User Detailes")
	@ApiResponse(responseCode = "200", description = "Fetch userDetails", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResponseMapper.class)))
	public UserDto findByEmail(@PathVariable String mailId) {
		
		return userService.getUserDetailsByEmail(mailId);
	}
	

}
