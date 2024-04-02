package org.generation.ecommerce.controller;
import java.util.List;

import org.generation.ecommerce.dto.ChangePassword;
import org.generation.ecommerce.model.User;
import org.generation.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/users/")
public class UserController {
	private final UserService userService;
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}//constructor
	
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}//getAllUser
	
	@GetMapping(path="{userId}")
	public User getUser(@PathVariable("userId") Long id){
		return userService.getUser(id);
	}//getUser
	
	@DeleteMapping(path="{userId}")
	public User deleteUser(@PathVariable("userId") Long id){
		return userService.deleteUser(id);
	}//deleteUser
	
	@PostMapping
	public User addUser(@RequestBody User usuario) {
		return userService.addUser(usuario);
	}//addUser
	
	@PutMapping (path="{userId}")
	public User updateUser(@PathVariable("userId") Long id, 
			@RequestBody ChangePassword changePassword ) {	
		return userService.updateUser(id, changePassword );
	}//updateUsuario
	
	
}//class UserController
