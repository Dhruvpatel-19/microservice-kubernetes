package com.microserviceexample.userservices.service;

import com.microserviceexample.userservices.VO.Department;
import com.microserviceexample.userservices.VO.ResponseTemplateVO;
import com.microserviceexample.userservices.entity.User;
import com.microserviceexample.userservices.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser method of UserService");
        return  userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(int userId) {
        ResponseTemplateVO obj = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId() , Department.class);

        obj.setUser(user);
        obj.setDepartment(department);

        return obj;
    }
}
