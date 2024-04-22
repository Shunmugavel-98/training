package com.shun.employeeservice.service.impl;

import com.shun.employeeservice.common.Constants;
import com.shun.employeeservice.exception.EmployeeNotFoundException;
import com.shun.employeeservice.exception.InternalException;
import com.shun.employeeservice.model.dto.EmployeeDto;
import com.shun.employeeservice.model.entity.Employee;
import com.shun.employeeservice.repository.EmployeeRepository;
import com.shun.employeeservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * Service class implementation for managing employee data.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private ModelMapper modelMapper = new ModelMapper();

    /**
     * <p>
     * Create a new employee.
     * </p>
     *
     * @param employeeDto The employee to be created
     * @return EmployeeDto The created employee
     * Throws InternalException if an internal server exception occur
     */
    public EmployeeDto createEmployee(EmployeeDto employeeDto) throws RuntimeException {
        Employee employee = employeeRepository.save(modelMapper.map(employeeDto, Employee.class));
        return modelMapper.map(employee, EmployeeDto.class);
    }

    /**
     * <p>
     * Get an employee by their ID.
     * </p>
     *
     * @param id The ID of the employee to retrieve
     * @return The employee with the specified ID
     * Throws EmployeeNotFoundException if resource not found
     */
    public EmployeeDto findById(long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(Constants.EMPLOYEE_NOT_FOUND + id));
        return modelMapper.map(employee, EmployeeDto.class);
    }

    /**
     * <p>
     * Delete an employee by their ID.
     * </p>
     *
     * @param id The ID of the employee to delete
     * @return The delete status message
     * Throws EmployeeNotFoundException if resource not found
     */
    public String deleteEmployee(long id) throws RuntimeException {
        Employee deleteEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(Constants.EMPLOYEE_NOT_FOUND + id));
        employeeRepository.delete(deleteEmployee);
        return Constants.DELETE_STATUS;
    }

    /**
     * <p>
     * Update an existing employee.
     * </p>
     *
     * @param employeeDetails The updated details of the employee
     * @return The updated employee
     * Throws EmployeeNotFoundException if resource not found
     */
    public EmployeeDto updateEmployee(EmployeeDto employeeDetails) throws RuntimeException {
        Employee updateEmployee = employeeRepository.findById(employeeDetails.getId())
                .orElseThrow(() -> new EmployeeNotFoundException(Constants.EMPLOYEE_NOT_FOUND + employeeDetails.getId()));
        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());
        Employee updatedEmployee = employeeRepository.save(updateEmployee);
        return modelMapper.map(updatedEmployee, EmployeeDto.class);
    }

    /**
     * <p>
     * Get all employees.
     * </p>
     *
     * @return A list of all employees
     * Throws RuntimeException if a run time exception occur
     */
    public List<EmployeeDto> getAllEmployees() throws RuntimeException {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().map(employee -> modelMapper.map(employee, EmployeeDto.class)).toList();
    }
}
