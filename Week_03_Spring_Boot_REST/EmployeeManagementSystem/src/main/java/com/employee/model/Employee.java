package com.employee.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Employee {
    private Long id;

    @NotBlank(message = "Employee name field cannot be empty.")
    @Size(min = 2, message = "Employee name must contain at least 2 characters.")
    private String name;

    @NotBlank(message = "Email field cannot be empty.")
    @Email(message = "Please provide a valid email format pattern.")
    private String email;

    public Employee() {}

    public Employee(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}