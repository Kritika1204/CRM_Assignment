package com.example.employee.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeListDto {
    private Long id;
    private String name;
    private String email;
    private String departmentName;
    private LocalDate dateOfJoining;
    private BigDecimal salary;
    private String managerName;

    public EmployeeListDto() {}

    public EmployeeListDto(Long id, String name, String email, String departmentName, 
                          LocalDate dateOfJoining, BigDecimal salary, String managerName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.departmentName = departmentName;
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
        this.managerName = managerName;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    public LocalDate getDateOfJoining() { return dateOfJoining; }
    public void setDateOfJoining(LocalDate dateOfJoining) { this.dateOfJoining = dateOfJoining; }

    public BigDecimal getSalary() { return salary; }
    public void setSalary(BigDecimal salary) { this.salary = salary; }

    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }
}