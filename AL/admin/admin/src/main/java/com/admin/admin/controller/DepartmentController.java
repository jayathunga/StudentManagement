package com.admin.admin.controller;

import com.admin.admin.dto.request.RequestDepartmentDto;
import com.admin.admin.dto.response.ResponseDepartmentDto;
import com.admin.admin.dto.response.ResponsesDepartmentList;
import com.admin.admin.entity.Department;
import com.admin.admin.entity.Employee;
import com.admin.admin.service.DepartmentService;
import com.admin.admin.service.EmployeeService;
import com.admin.admin.transformer.DepartmentTransformer;
import com.admin.admin.util.StandardResponse;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@Data
@RequestMapping(value = "api/v1/dep",produces = MediaType.APPLICATION_JSON_VALUE)
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
   public ResponseEntity<StandardResponse>createDepartment(@RequestBody RequestDepartmentDto requestDepartmentDto){
        Department department=new Department();
        department.setName(requestDepartmentDto.getName());
        Department createdDepartment=departmentService.createDepartment(department);

        for(Employee employee:requestDepartmentDto.getEmployees()){
               employee.setDepartment(createdDepartment);
               employeeService.createEmployee(employee);
        }
        return new ResponseEntity<>(
                new StandardResponse(201,"Department saved",createdDepartment.getId()),
                HttpStatus.CREATED
        );

   }

   @GetMapping("/getAll")
   public @ResponseBody ResponsesDepartmentList getAllDepartment(){
       List<Department>departmentList=departmentService.getAllDepartment();
       List<ResponseDepartmentDto> responseDepartmentDtoList=DepartmentTransformer.DomainListToResponseList(departmentList);
       ResponsesDepartmentList responseList=new ResponsesDepartmentList();
       responseList.setResponseDepartmentDtoList(responseDepartmentDtoList);
       return responseList;

   }
   @PutMapping("/updateDepartment/{id}")
  public @ResponseBody ResponseDepartmentDto updateDepartment(@RequestBody RequestDepartmentDto requestDepartmentDto,@PathVariable String id){
        Department department=DepartmentTransformer.updateRequestToDomain(requestDepartmentDto);
        Department updatedDepartment=departmentService.updateDepartment(department,id);
        return DepartmentTransformer.DomainToResponse(updatedDepartment);

  }

  @GetMapping("/getOne/{id}")
  public @ResponseBody ResponseDepartmentDto getOneDepartment(@PathVariable String id){
        Department department=departmentService.getOnedepartment(id);
        return DepartmentTransformer.DomainToResponse(department);
  }

}
