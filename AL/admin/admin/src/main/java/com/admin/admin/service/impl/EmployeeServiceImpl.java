package com.admin.admin.service.impl;

import com.admin.admin.entity.Department;
import com.admin.admin.entity.Employee;
import com.admin.admin.repository.EmployeeRepo;
import com.admin.admin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }


}
