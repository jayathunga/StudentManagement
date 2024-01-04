package com.admin.admin.transformer;

import com.admin.admin.dto.request.RequestDepartmentDto;
import com.admin.admin.dto.response.ResponseDepartmentDto;
import com.admin.admin.entity.Department;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public final class DepartmentTransformer {

    private DepartmentTransformer(){

    }

   public static Department RequestToDomain(RequestDepartmentDto requestDepartmentDto){
        Department target=new Department();
       BeanUtils.copyProperties(requestDepartmentDto,target);
       return target;
   }

   public static ResponseDepartmentDto DomainToResponse(Department department){
        ResponseDepartmentDto target=new ResponseDepartmentDto();
        BeanUtils.copyProperties(department,target);
        return target;
   }

   public static List<ResponseDepartmentDto>DomainListToResponseList(List<Department>departmentList){
       List<ResponseDepartmentDto>target=new ArrayList<>();
       for(Department department:departmentList){
           ResponseDepartmentDto responseDepartmentDto=DomainToResponse(department);
           target.add(responseDepartmentDto);
       }
       return target;

   }

   public static Department updateRequestToDomain(RequestDepartmentDto requestDepartmentDto){
        Department target=new Department();
        target.setName(requestDepartmentDto.getName());
        return target;
   }
}
