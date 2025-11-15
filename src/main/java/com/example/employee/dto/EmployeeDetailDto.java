package com.example.employee.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class EmployeeDetailDto {
    private Long id;
    private String name;
    private String email;
    private LocalDate dateOfJoining;
    private BigDecimal salary;
    private DepartmentDto department;
    private String managerName;
    private List<ProjectDto> projects;
    private List<PerformanceReviewDto> recentReviews;

    public EmployeeDetailDto() {}

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

    public DepartmentDto getDepartment() { return department; }
    public void setDepartment(DepartmentDto department) { this.department = department; }

    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }

    public List<ProjectDto> getProjects() { return projects; }
    public void setProjects(List<ProjectDto> projects) { this.projects = projects; }

    public List<PerformanceReviewDto> getRecentReviews() { return recentReviews; }
    public void setRecentReviews(List<PerformanceReviewDto> recentReviews) { this.recentReviews = recentReviews; }

    public static class DepartmentDto {
        private Long id;
        private String name;
        private BigDecimal budget;

        public DepartmentDto() {}

        public DepartmentDto(Long id, String name, BigDecimal budget) {
            this.id = id;
            this.name = name;
            this.budget = budget;
        }

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public BigDecimal getBudget() { return budget; }
        public void setBudget(BigDecimal budget) { this.budget = budget; }
    }

    public static class ProjectDto {
        private Long id;
        private String name;
        private LocalDate startDate;
        private LocalDate endDate;
        private String role;
        private LocalDate assignedDate;

        public ProjectDto() {}

        public ProjectDto(Long id, String name, LocalDate startDate, LocalDate endDate, String role, LocalDate assignedDate) {
            this.id = id;
            this.name = name;
            this.startDate = startDate;
            this.endDate = endDate;
            this.role = role;
            this.assignedDate = assignedDate;
        }

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public LocalDate getStartDate() { return startDate; }
        public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

        public LocalDate getEndDate() { return endDate; }
        public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

        public String getRole() { return role; }
        public void setRole(String role) { this.role = role; }

        public LocalDate getAssignedDate() { return assignedDate; }
        public void setAssignedDate(LocalDate assignedDate) { this.assignedDate = assignedDate; }
    }

    public static class PerformanceReviewDto {
        private Long id;
        private LocalDate reviewDate;
        private Integer score;
        private String reviewComments;

        public PerformanceReviewDto() {}

        public PerformanceReviewDto(Long id, LocalDate reviewDate, Integer score, String reviewComments) {
            this.id = id;
            this.reviewDate = reviewDate;
            this.score = score;
            this.reviewComments = reviewComments;
        }

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public LocalDate getReviewDate() { return reviewDate; }
        public void setReviewDate(LocalDate reviewDate) { this.reviewDate = reviewDate; }

        public Integer getScore() { return score; }
        public void setScore(Integer score) { this.score = score; }

        public String getReviewComments() { return reviewComments; }
        public void setReviewComments(String reviewComments) { this.reviewComments = reviewComments; }
    }
}