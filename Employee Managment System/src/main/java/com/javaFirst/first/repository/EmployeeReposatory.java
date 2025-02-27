package com.javaFirst.first.repository;

import com.javaFirst.first.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeReposatory extends JpaRepository<Employee, Long> {
}
