package com.verizontraining.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

	@GetMapping("/send-email")
	public String sendEmail() {
		System.out.println("Email Has been sent");
		return "Email sent successfully";
	}
}
