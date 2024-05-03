package com.shun.employeeservice.model.entity;

import com.shun.employeeservice.common.TableConstants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * <p>
 * Employee class represents an employee entity.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
@Data
@Entity
@Table(name = TableConstants.EMPLOYEE)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = TableConstants.FIRST_NAME)
    private String firstName;

    @Column(name = TableConstants.LAST_NAME)
    private String lastName;

    @Column(name = TableConstants.EMAIL_ID)
    private String emailId;

    @Column(name = TableConstants.PHONE)
    private String phone;
}
