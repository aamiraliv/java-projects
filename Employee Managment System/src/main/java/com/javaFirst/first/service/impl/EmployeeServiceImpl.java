package com.javaFirst.first.service.impl;

import com.javaFirst.first.dto.EmployeeDto;
import com.javaFirst.first.entity.Employee;
import com.javaFirst.first.mapper.EmployeeMapper;
import com.javaFirst.first.repository.EmployeeRepository;
import com.javaFirst.first.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
