package com.microserviceexample.department.repository;

import com.microserviceexample.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department , Integer> {

    Department findByDepartmentId(int id);
}
