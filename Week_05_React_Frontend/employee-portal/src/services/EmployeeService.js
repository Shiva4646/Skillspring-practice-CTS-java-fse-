import axios from 'axios';

// The exact URL to reach your Spring Boot backend from Week 3
const BACKEND_URL = 'http://localhost:8081/api/employees';

// Function 1: Fetch all employee records from the backend
export function fetchAllEmployees() {
    return axios.get(BACKEND_URL);
}

// Function 2: Send new employee data to the backend
export function registerNewEmployee(employeeData) {
    return axios.post(BACKEND_URL, employeeData);
}