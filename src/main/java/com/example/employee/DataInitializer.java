package com.example.employee;

import com.example.employee.model.*;
import com.example.employee.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private DepartmentRepository departmentRepository;
    
    @Autowired
    private ProjectRepository projectRepository;
    
    @Autowired
    private PerformanceReviewRepository performanceReviewRepository;
    
    @Autowired
    private EmployeeProjectRepository employeeProjectRepository;

    @Override
    public void run(String... args) throws Exception {
        // Create Departments
        Department engineering = new Department("Engineering", new BigDecimal("1000000"));
        Department marketing = new Department("Marketing", new BigDecimal("500000"));
        Department hr = new Department("Human Resources", new BigDecimal("300000"));
        
        departmentRepository.save(engineering);
        departmentRepository.save(marketing);
        departmentRepository.save(hr);

        // Create Employees
        Employee john = new Employee("John Doe", "john.doe@company.com", LocalDate.of(2020, 1, 15), new BigDecimal("75000"));
        john.setDepartment(engineering);
        
        Employee jane = new Employee("Jane Smith", "jane.smith@company.com", LocalDate.of(2019, 3, 10), new BigDecimal("85000"));
        jane.setDepartment(engineering);
        
        Employee bob = new Employee("Bob Johnson", "bob.johnson@company.com", LocalDate.of(2021, 6, 1), new BigDecimal("65000"));
        bob.setDepartment(marketing);
        bob.setManager(jane);
        
        Employee alice = new Employee("Alice Brown", "alice.brown@company.com", LocalDate.of(2022, 2, 14), new BigDecimal("70000"));
        alice.setDepartment(hr);
        alice.setManager(jane);

        employeeRepository.save(john);
        employeeRepository.save(jane);
        employeeRepository.save(bob);
        employeeRepository.save(alice);

        // Create Projects
        Project webApp = new Project("Web Application", LocalDate.of(2023, 1, 1), LocalDate.of(2023, 12, 31));
        webApp.setDepartment(engineering);
        
        Project mobileApp = new Project("Mobile App", LocalDate.of(2023, 3, 1), LocalDate.of(2024, 2, 28));
        mobileApp.setDepartment(engineering);
        
        Project campaign = new Project("Marketing Campaign", LocalDate.of(2023, 6, 1), LocalDate.of(2023, 9, 30));
        campaign.setDepartment(marketing);

        projectRepository.save(webApp);
        projectRepository.save(mobileApp);
        projectRepository.save(campaign);

        // Create Employee-Project assignments
        EmployeeProject johnWebApp = new EmployeeProject(LocalDate.of(2023, 1, 1), "Lead Developer");
        johnWebApp.setEmployee(john);
        johnWebApp.setProject(webApp);
        
        EmployeeProject janeMobileApp = new EmployeeProject(LocalDate.of(2023, 3, 1), "Project Manager");
        janeMobileApp.setEmployee(jane);
        janeMobileApp.setProject(mobileApp);
        
        EmployeeProject bobCampaign = new EmployeeProject(LocalDate.of(2023, 6, 1), "Marketing Specialist");
        bobCampaign.setEmployee(bob);
        bobCampaign.setProject(campaign);

        employeeProjectRepository.save(johnWebApp);
        employeeProjectRepository.save(janeMobileApp);
        employeeProjectRepository.save(bobCampaign);

        // Create Performance Reviews
        PerformanceReview johnReview1 = new PerformanceReview(LocalDate.of(2023, 6, 30), 8, "Excellent performance on web application project");
        johnReview1.setEmployee(john);
        
        PerformanceReview johnReview2 = new PerformanceReview(LocalDate.of(2023, 12, 31), 9, "Outstanding leadership and technical skills");
        johnReview2.setEmployee(john);
        
        PerformanceReview janeReview1 = new PerformanceReview(LocalDate.of(2023, 6, 30), 9, "Great project management and team leadership");
        janeReview1.setEmployee(jane);
        
        PerformanceReview bobReview1 = new PerformanceReview(LocalDate.of(2023, 9, 30), 7, "Good performance on marketing campaign");
        bobReview1.setEmployee(bob);

        performanceReviewRepository.save(johnReview1);
        performanceReviewRepository.save(johnReview2);
        performanceReviewRepository.save(janeReview1);
        performanceReviewRepository.save(bobReview1);
    }
}