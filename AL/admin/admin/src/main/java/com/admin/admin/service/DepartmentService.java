package com.admin.admin.service;

import com.admin.admin.entity.Department;

import java.util.List;

public interface DepartmentService {

    Department createDepartment(Department department);

    List<Department> getAllDepartment();

    Department updateDepartment(Department department,String id);

    Department getOnedepartment(String id);
}
