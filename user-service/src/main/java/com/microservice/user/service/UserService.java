package com.microservice.user.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.user.VO.Department;
import com.microservice.user.VO.ResponseTemplateVO;
import com.microservice.user.entity.User;
import com.microservice.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
 
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		// TODO Auto-generated method stub
//		log.info("Inside saveUser method in UserService");
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		// TODO Auto-generated method stub
		log.info("Inside getUserWithDepartment method in UserService");
		ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
		User user=userRepository.findByUserId(userId);
		log.info(" "+user.getUserId());
		Department department=restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
//		User user2= new User();
	
		responseTemplateVO.setUser(user);
		responseTemplateVO.setDepartment(department);
		return responseTemplateVO;
	}
}
