package com.employee.controller;

import com.employee.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    private final List<Employee> mockDatabase = new ArrayList<>();

    public EmployeeController() {
        // Hydrate with an initial structural baseline record
        mockDatabase.add(new Employee(101L, "Shiva Raman", "shiva@corporation.com"));
    }

    // GET Endpoint: Fetch all records
    @GetMapping
    public List<Employee> fetchAllEmployees() {
        logger.info("[REST API Engine]: Processing collection index retrieval request maps.");
        return mockDatabase;
    }

    // POST Endpoint: Insert data after passing through the validation filter block
    @PostMapping
    public ResponseEntity<String> registerNewEmployee(@Valid @RequestBody Employee employee) {
        logger.info("[REST API Engine]: Intercepting inbound entity payload data stream.");
        employee.setId((long) (mockDatabase.size() + 101));
        mockDatabase.add(employee);
        return new ResponseEntity<>("Employee asset saved successfully!", HttpStatus.CREATED);
    }
}