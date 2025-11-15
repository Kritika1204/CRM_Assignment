package com.example.employee.repository;

import com.example.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    @Query("SELECT DISTINCT e FROM Employee e " +
           "LEFT JOIN e.performanceReviews pr " +
           "LEFT JOIN e.employeeProjects ep " +
           "LEFT JOIN ep.project p " +
           "WHERE (:score IS NULL OR (pr.reviewDate = :reviewDate AND pr.score = :score)) " +
           "AND (:departments IS NULL OR e.department.name IN :departments) " +
           "AND (:projects IS NULL OR p.name IN :projects)")
    List<Employee> findEmployeesWithFilters(@Param("score") Integer score,
                                          @Param("reviewDate") LocalDate reviewDate,
                                          @Param("departments") List<String> departments,
                                          @Param("projects") List<String> projects);
}