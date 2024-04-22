package com.shun.employeeservice.service;

import com.shun.employeeservice.model.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    /**
     * Create a new employee.
     *
     * @param  employeeDto  the employee to be created
     * @return Employee  a new employee created
     */
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    /**
     * Retrieves an employee by their ID.
     *
     * @param  id  the ID of the employee to retrieve
     * @return Employee the employee with the specified ID, or null if not found
     */
    EmployeeDto findById(long id);

    /**
     * Updates an existing employee with the provided details.
     *
     * @param  employeeDetails  the updated details of the employee
     * @return Employee         the updated employee
     */
    EmployeeDto updateEmployee(EmployeeDto employeeDetails);

    /**
     * Deletes an employee with the specified ID.
     *
     * @param  id  the ID of the employee to be deleted
     * @return String a string indicating the status of the deletion operation
     */
    String deleteEmployee(long id);

    /**
     * Retrieves a list of all employees.
     *
     * @return a list of Employee objects representing all employees
     */
    List<EmployeeDto> getAllEmployees();
}
