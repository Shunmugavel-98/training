package com.shun.employeeservice.controller;

import com.shun.employeeservice.common.Constants;
import com.shun.employeeservice.common.GenericResponse;
import com.shun.employeeservice.exception.AccessDeniedException;
import com.shun.employeeservice.model.dto.EmployeeDto;
import com.shun.employeeservice.model.entity.Employee;
import com.shun.employeeservice.service.EmployeeService;
import com.shun.employeeservice.util.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.RoleNotFoundException;
import java.util.List;

/**
 * <p>
 * Controller for managing employee-related operations.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    JwtUtils jwtUtils;

    /**
     * <p>
     * Create a new employee.
     * </p>
     *
     * @param employeeDetails The employee to be created
     * @return GenericResponse containing the created employee
     */
    @PostMapping
    public GenericResponse<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDetails) {
        EmployeeDto employeeDto = employeeService.createEmployee(employeeDetails);
        return new GenericResponse<>(employeeDto, Constants.CREATED_STATUS, HttpStatus.CREATED);
    }

    /**
     * <p>
     * Get an employee by their ID.
     * </p>
     *
     * @param id The ID of the employee to retrieve
     * @return GenericResponse containing the employee with the specified ID
     */
    @GetMapping("{id}")
    public GenericResponse<EmployeeDto> getEmployeeById(@PathVariable long id) {
        EmployeeDto employeeDto = employeeService.findById(id);
        return new GenericResponse<>(employeeDto, Constants.FETCH_STATUS, HttpStatus.OK);
    }

    /**
     * <p>
     * Update an existing employee.
     * </p>
     *
     * @param employeeDetails The updated details of the employee
     * @return GenericResponse containing the updated employee
     */
    @PutMapping
    public GenericResponse<Employee> updateEmployee(@RequestBody EmployeeDto employeeDetails) {
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeDetails);
        return new GenericResponse<>(employeeDto, Constants.UPDATE_STATUS, HttpStatus.OK);
    }

    /**
     * <p>
     * Delete an employee by their ID.
     * </p>
     *
     * @param id The ID of the employee to delete
     * @return GenericResponse containing the delete status message
     */
    @DeleteMapping("{id}")
    public GenericResponse<String> deleteEmployee(@PathVariable long id) {
        String status = employeeService.deleteEmployee(id);
        return new GenericResponse<>(status, HttpStatus.OK);
    }

    /**
     * <p>
     * Get all employees.
     * </p>
     *
     * @return GenericResponse containing a list of all employees
     */
    @GetMapping
    public GenericResponse<List<EmployeeDto>> getAllEmployees(@RequestHeader("Authorization") String authorization) throws RuntimeException {
        Claims claims = jwtUtils.parseJwt(authorization);
        if (claims.get(Constants.ROLE, String.class).equals(Constants.USER_TYPE_NORMAL)) {
            List<EmployeeDto> employeeList = employeeService.getAllEmployees();
            return new GenericResponse<>(employeeList, Constants.FETCH_STATUS, HttpStatus.OK);
        } else {
            throw new AccessDeniedException("Access Denied. User does not have required role");
        }
    }
}
