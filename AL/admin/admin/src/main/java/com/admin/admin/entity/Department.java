package com.admin.admin.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    @Column(name = "dep_id")
    private String id;

    @Column(name = "DepName")
    private String name;

    @OneToMany(mappedBy ="department" ,cascade = CascadeType.ALL)

    List<Employee> employees=new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
        for(Employee data:employees){
            data.setDepartment(this);
        }
    }

    public void merge(Department department){
     if(department.name!=this.name){
         this.name=department.name;
     }
    }
}
