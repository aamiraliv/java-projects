package com.javaFirst.first.controller;

import com.javaFirst.first.dto.EmployeeDto;
import com.javaFirst.first.service.EmployeeServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    private EmployeeServices employeeServices;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee (@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeServices.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee , HttpStatus.CREATED);
    }
}
