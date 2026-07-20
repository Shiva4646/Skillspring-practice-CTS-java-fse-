import React, { useState, useEffect } from 'react';
import { fetchAllEmployees, registerNewEmployee } from '../services/EmployeeService';

export default function EmployeeDashboard() {
    // Standard variables to hold our application data
    const [employees, setEmployees] = useState([]);
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');

    // Variables to show basic messages on the screen
    const [errorMessage, setErrorMessage] = useState('');
    const [successMessage, setSuccessMessage] = useState('');

    // Function to load the data from our backend service
    function loadRecords() {
        fetchAllEmployees()
            .then((response) => {
                setEmployees(response.data); // Save the list of employees
            })
            .catch((error) => {
                console.error("Could not fetch database records:", error);
            });
    }

    // Load data automatically when the page opens
    useEffect(() => {
        loadRecords();
    }, []);

    // Function to handle form submission when clicking the submit button
    function handleFormSubmit(event) {
        event.preventDefault(); // Stop the page from reloading
        setErrorMessage('');
        setSuccessMessage('');

        // 1. Beginner Validation Check: Check if fields are empty
        if (name === '' || email === '') {
            setErrorMessage('Error: All text boxes are mandatory!');
            return;
        }

        // 2. Beginner Validation Check: Basic email symbol validation
        if (email.includes('@') === false || email.includes('.') === false) {
            setErrorMessage('Error: Please enter a valid email containing @ and .');
            return;
        }

        // Bundle data into a simple object
        const newEmployee = {
            name: name,
            email: email
        };

        // Send the data object to our backend API service
        registerNewEmployee(newEmployee)
            .then(() => {
                setSuccessMessage('✔ Success: Record saved to database!');
                setName('');  // Clear input box
                setEmail(''); // Clear input box
                loadRecords(); // Refresh table list view automatically
            })
            .catch((error) => {
                setErrorMessage('Connection failed. Make sure your Spring Boot app is running on port 8081.');
            });
    }

    return (
        <div style={{ padding: '25px', maxWidth: '700px', margin: '0 auto', fontFamily: 'Arial' }}>
            <h2 style={{ borderBottom: '2px solid blue', paddingBottom: '10px' }}>
                Cognizant DN 5.0 — Week 5 UI Dashboard
            </h2>

            {/* Registration Form Box */}
            <div style={{ background: '#f5f5f5', padding: '15px', borderRadius: '5px', marginBottom: '20px' }}>
                <h3>Add New Employee Form</h3>

                {/* Conditional rendering to display messages safely */}
                {errorMessage !== '' && <p style={{ color: 'red', fontWeight: 'bold' }}>{errorMessage}</p>}
                {successMessage !== '' && <p style={{ color: 'green', fontWeight: 'bold' }}>{successMessage}</p>}

                <div style={{ marginBottom: '10px' }}>
                    <label>Employee Name: </label>
                    <input type="text" style={{ width: '100%', padding: '5px' }} value={name} onChange={(e) => setName(e.target.value)} placeholder="Enter name" />
                </div>

                <div style={{ marginBottom: '10px' }}>
                    <label>Email Address: </label>
                    <input type="text" style={{ width: '100%', padding: '5px' }} value={email} onChange={(e) => setEmail(e.target.value)} placeholder="Enter email" />
                </div>

                <button type="button" onClick={handleFormSubmit} style={{ padding: '8px 15px', background: 'blue', color: 'white', border: 'none', cursor: 'pointer' }}>
                    Submit Employee Record
                </button>
            </div>

            {/* Data Grid Table Layout View */}
            <h3>Registered Management List</h3>
            <table border="1" cellPadding="10" style={{ width: '100%', borderCollapse: 'collapse' }}>
                <thead style={{ background: 'blue', color: 'white' }}>
                <tr>
                    <th>Tracking ID</th>
                    <th>Employee Name</th>
                    <th>Email Profile</th>
                </tr>
                </thead>
                <tbody>
                {employees.length === 0 ? (
                    <tr><td colSpan="3" style={{ textAlign: 'center' }}>No records found. Please start your Spring Boot server.</td></tr>
                ) : (
                    employees.map((emp) => (
                        <tr key={emp.id}>
                            <td>{emp.id}</td>
                            <td>{emp.name}</td>
                            <td>{emp.email}</td>
                        </tr>
                    ))
                )}
                </tbody>
            </table>
        </div>
    );
}