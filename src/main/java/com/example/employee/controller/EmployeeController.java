package com.example.employee.controller;

import com.example.employee.dto.EmployeeDetailDto;
import com.example.employee.dto.EmployeeListDto;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeListDto>> getEmployees(
            @RequestParam(required = false) Integer score,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reviewDate,
            @RequestParam(required = false) List<String> departments,
            @RequestParam(required = false) List<String> projects) {
        
        List<EmployeeListDto> employees = employeeService.getEmployeesWithFilters(score, reviewDate, departments, projects);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDetailDto> getEmployeeDetail(@PathVariable Long id) {
        Optional<EmployeeDetailDto> employee = employeeService.getEmployeeDetail(id);
        
        if (employee.isPresent()) {
            return ResponseEntity.ok(employee.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}