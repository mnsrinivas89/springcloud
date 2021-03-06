package com.verizontraining.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.verizontraining.models.User;
import com.verizontraining.repositories.NotificationServiceProxy;
import com.verizontraining.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService uService;
	
	@Autowired
	private NotificationServiceProxy nProxy;
	
	
	@PostMapping("/register")
	public User register(@RequestBody User user) throws Exception {
		//check the email provided by the user is existing or not
		if(!uService.getUsersByEmailId(user.getEmail()).isEmpty()) {
			throw new Exception("User Exists");
		}
		//proceed with saving the user
		uService.saveUser(user);
		
		//send a notification mail to customer
		nProxy.sendEmail();
		
		
		return null;
	}
}
