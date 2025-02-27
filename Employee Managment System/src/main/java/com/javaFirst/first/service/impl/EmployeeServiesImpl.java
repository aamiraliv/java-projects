package com.javaFirst.first.service.impl;

import com.javaFirst.first.dto.EmployeeDto;
import com.javaFirst.first.entity.Employee;
import com.javaFirst.first.mapper.EmployeeMapper;
import com.javaFirst.first.repository.EmployeeReposatory;
import com.javaFirst.first.service.EmployeeServices;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiesImpl implements EmployeeServices {

    private EmployeeReposatory employeeReposatory;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeReposatory.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
