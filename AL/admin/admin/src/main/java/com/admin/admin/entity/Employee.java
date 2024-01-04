package com.admin.admin.entity;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    private String id;
    private String empName;

    @ManyToOne
    @JoinColumn(name="dep_id",nullable = false)
    private Department department;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
        department.getEmployees().add(this);
    }
}
