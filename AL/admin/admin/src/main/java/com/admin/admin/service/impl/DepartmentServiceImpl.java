package com.admin.admin.service.impl;

import com.admin.admin.entity.Department;
import com.admin.admin.repository.DepartmentRepo;
import com.admin.admin.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;
    @Override
    public Department createDepartment(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepo.findAll();
    }

    @Override
    public Department updateDepartment(Department department, String id) {
        Department existingDepartment=departmentRepo.findById(id).orElse(null);
        if(existingDepartment!=null){
            existingDepartment.merge(department);
        }
        return departmentRepo.save(existingDepartment);
    }

    @Override
    public Department getOnedepartment(String id) {
        return departmentRepo.findById(id).orElse(null);
    }
}
