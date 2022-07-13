package com.microserviceexample.department.service;

import com.microserviceexample.department.entity.Department;
import com.microserviceexample.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment of DepartmentService");
        return  departmentRepository.save(department);
    }

    public Department findDepartmentById(int id) {
        return departmentRepository.findByDepartmentId(id);
    }

}
