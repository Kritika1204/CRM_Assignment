package com.example.employee.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "performance_reviews")
public class PerformanceReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "review_date", nullable = false)
    private LocalDate reviewDate;

    @Min(1)
    @Max(10)
    @Column(nullable = false)
    private Integer score;

    @Column(name = "review_comments", columnDefinition = "TEXT")
    private String reviewComments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    public PerformanceReview() {}

    public PerformanceReview(LocalDate reviewDate, Integer score, String reviewComments) {
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

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
}