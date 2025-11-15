package com.example.employee.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(name = "date_of_joining", nullable = false)
    private LocalDate dateOfJoining;

    @Positive
    @Column(nullable = false)
    private BigDecimal salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    private List<Employee> subordinates;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<PerformanceReview> performanceReviews;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<EmployeeProject> employeeProjects;

    public Employee() {}

    public Employee(String name, String email, LocalDate dateOfJoining, BigDecimal salary) {
        this.name = name;
        this.email = email;
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getDateOfJoining() { return dateOfJoining; }
    public void setDateOfJoining(LocalDate dateOfJoining) { this.dateOfJoining = dateOfJoining; }

    public BigDecimal getSalary() { return salary; }
    public void setSalary(BigDecimal salary) { this.salary = salary; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public Employee getManager() { return manager; }
    public void setManager(Employee manager) { this.manager = manager; }

    public List<Employee> getSubordinates() { return subordinates; }
    public void setSubordinates(List<Employee> subordinates) { this.subordinates = subordinates; }

    public List<PerformanceReview> getPerformanceReviews() { return performanceReviews; }
    public void setPerformanceReviews(List<PerformanceReview> performanceReviews) { this.performanceReviews = performanceReviews; }

    public List<EmployeeProject> getEmployeeProjects() { return employeeProjects; }
    public void setEmployeeProjects(List<EmployeeProject> employeeProjects) { this.employeeProjects = employeeProjects; }
}