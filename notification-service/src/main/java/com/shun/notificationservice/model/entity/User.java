package com.shun.notificationservice.model.entity;

import com.shun.notificationservice.common.Constants;
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
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "phone")
    private String phone;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "incorrect_login_attempts")
    private Integer incorrectLoginAttempts;

    @Column(name = "retry_period")
    private LocalDateTime retryPeriod;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "verificationCode", length = Constants.VERIFICATION_CODE_LENGTH)
    private String verificationCode;

    @PrePersist
    public void onSave() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        if (createdAt == null) {
            this.createdAt = currentDateTime;
        }
        this.updatedAt = currentDateTime;
    }

    @PostPersist
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
