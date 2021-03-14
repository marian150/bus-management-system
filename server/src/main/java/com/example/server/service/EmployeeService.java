package com.example.server.service;

import com.example.server.entity.Employee;
import com.example.server.exception.RecordNotFoundException;
import com.example.server.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee findByName(String name){
        return employeeRepository.findByName(name).orElseThrow(() -> new RecordNotFoundException("Employee not found"));
    }
}
