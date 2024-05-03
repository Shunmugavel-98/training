package com.shun.employeeservice.model.entity;

import com.shun.employeeservice.common.Constants;
import com.shun.employeeservice.common.TableConstants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>
 * User class represents a user entity.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
@Entity
@Data
@Table(name = TableConstants.USER)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = TableConstants.NAME)
    private String name;

    @Column(name = TableConstants.PASSWORD)
    private String password;

    @Column(name = TableConstants.EMAIL_ID)
    private String emailId;

    @Column(name = TableConstants.PHONE)
    private String phone;

    @Column(name = TableConstants.IS_ACTIVE)
    private Boolean isActive;

    @Column(name = TableConstants.USER_TYPE)
    private String userType;

    @Column(name = TableConstants.INCORRECT_LOGIN_ATTEMPTS)
    private Integer incorrectLoginAttempts;

    @Column(name = TableConstants.RETRY_PERIOD)
    private LocalDateTime retryPeriod;

    @Column(name = TableConstants.CREATED_AT)
    private LocalDateTime createdAt;

    @Column(name = TableConstants.UPDATED_AT)
    private LocalDateTime updatedAt;

    @Column(name = TableConstants.CREATED_BY)
    private Long createdBy;

    @Column(name = TableConstants.UPDATED_BY)
    private Long updatedBy;

    @Column(name = TableConstants.VERIFICATION_CODE, length = Constants.VERIFICATION_CODE_LENGTH)
    private String verificationCode;

    @PrePersist
    public void onSave() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        if (null == createdAt) {
            this.createdAt = currentDateTime;
        }
        this.updatedAt = currentDateTime;
    }

    @PostPersist
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
