package com.example.employee.service;

import com.example.employee.dto.EmployeeDetailDto;
import com.example.employee.dto.EmployeeListDto;
import com.example.employee.model.Employee;
import com.example.employee.model.EmployeeProject;
import com.example.employee.model.PerformanceReview;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.repository.PerformanceReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PerformanceReviewRepository performanceReviewRepository;

    public List<EmployeeListDto> getEmployeesWithFilters(Integer score, LocalDate reviewDate, 
                                                        List<String> departments, List<String> projects) {
        List<Employee> employees = employeeRepository.findEmployeesWithFilters(score, reviewDate, departments, projects);
        
        return employees.stream()
                .map(this::convertToListDto)
                .collect(Collectors.toList());
    }

    public Optional<EmployeeDetailDto> getEmployeeDetail(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        
        if (employee.isPresent()) {
            return Optional.of(convertToDetailDto(employee.get()));
        }
        return Optional.empty();
    }

    private EmployeeListDto convertToListDto(Employee employee) {
        return new EmployeeListDto(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getDepartment() != null ? employee.getDepartment().getName() : null,
                employee.getDateOfJoining(),
                employee.getSalary(),
                employee.getManager() != null ? employee.getManager().getName() : null
        );
    }

    private EmployeeDetailDto convertToDetailDto(Employee employee) {
        EmployeeDetailDto dto = new EmployeeDetailDto();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setEmail(employee.getEmail());
        dto.setDateOfJoining(employee.getDateOfJoining());
        dto.setSalary(employee.getSalary());
        dto.setManagerName(employee.getManager() != null ? employee.getManager().getName() : null);

        if (employee.getDepartment() != null) {
            dto.setDepartment(new EmployeeDetailDto.DepartmentDto(
                    employee.getDepartment().getId(),
                    employee.getDepartment().getName(),
                    employee.getDepartment().getBudget()
            ));
        }

        List<EmployeeDetailDto.ProjectDto> projects = employee.getEmployeeProjects().stream()
                .map(ep -> new EmployeeDetailDto.ProjectDto(
                        ep.getProject().getId(),
                        ep.getProject().getName(),
                        ep.getProject().getStartDate(),
                        ep.getProject().getEndDate(),
                        ep.getRole(),
                        ep.getAssignedDate()
                ))
                .collect(Collectors.toList());
        dto.setProjects(projects);

        List<PerformanceReview> recentReviews = performanceReviewRepository
                .findTop3ByEmployeeIdOrderByReviewDateDesc(employee.getId())
                .stream()
                .limit(3)
                .collect(Collectors.toList());

        List<EmployeeDetailDto.PerformanceReviewDto> reviewDtos = recentReviews.stream()
                .map(pr -> new EmployeeDetailDto.PerformanceReviewDto(
                        pr.getId(),
                        pr.getReviewDate(),
                        pr.getScore(),
                        pr.getReviewComments()
                ))
                .collect(Collectors.toList());
        dto.setRecentReviews(reviewDtos);

        return dto;
    }
}