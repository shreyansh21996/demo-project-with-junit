package com.demo.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.test.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
