package com.shun.employeeservice.repository;

import com.shun.employeeservice.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Repository interface for Employee entity.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
