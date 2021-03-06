package com.verizontraining.repositories;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="apigateway")
@RibbonClient(name="apigateway")
public interface NotificationServiceProxy {
	
	@GetMapping("/notification-service/send-email")
	public String sendEmail();
	//http://apigateway/notification-service/send-email
	
	
	
}
