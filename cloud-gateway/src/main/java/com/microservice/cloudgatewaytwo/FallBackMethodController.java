package com.microservice.cloudgatewaytwo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

	@GetMapping("/userServiceFallBack")
	public String userServiceFallBackMehod() {
		return "UserService is taking longer than expected!!.Please TRy again";
	}
	
	@GetMapping("/departmentServiceFallBack")
	public String departmentServiceFallBackMehod() {
		return "DepartmentService is taking longer than expected!!.Please TRy again";
	}
}
