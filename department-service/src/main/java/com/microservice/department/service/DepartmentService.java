package com.microservice.department.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.department.entity.Department;
import com.microservice.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
//		log.info("Inside saveDepartment method in departmentService");
		return departmentRepository.save(department);
	}

	public Department findDepartmentById(long departmentId) {
		// TODO Auto-generated method stub
//		log.info("Inside findDepartmentById method in DepartmentService");
		return departmentRepository.findByDepartmentId(departmentId);
	}
	
	
	
	
}
