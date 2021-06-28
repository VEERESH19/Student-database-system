package com.veer.studentdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.veer.studentdb.Interface.UserContIntrf;
import com.veer.studentdb.entity.User;
import com.veer.studentdb.request.UserRequest;
import com.veer.studentdb.service.UserService;

import javax.annotation.PostConstruct;

@RestController
public class UserController implements UserContIntrf {

	@Autowired
	private UserService userService;

	/*
	 * @PostConstruct public void UserRole() {
	 * System.out.println("set default user function "); userService.UserRole();
	 * 
	 * }
	 */

	@Override
	@PostMapping("/adduser")
	public User addUser(@RequestBody UserRequest userRequest) {

		System.out.println("User controller");
		return userService.addUser(userRequest);
	}

	/*
	 * @DeleteMapping("/removeuser/{user_id}")
	 * 
	 * @PreAuthorize("hasRole('Admin')") public void
	 * delUser(@PathVariable("user_id") Long user_id) {
	 * userService.delUser(user_id);
	 * 
	 * }
	 */

}
