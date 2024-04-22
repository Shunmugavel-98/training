package com.shun.notificationservice.repository;

import com.shun.notificationservice.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * <p>
     * Find a user by their verification code.
     * </p>
     *
     * @param verificationCode the verification code
     * @return the user with the specified verification code, or null if not found
     */
    User findByVerificationCodeAndIsActiveFalse(String verificationCode);
}
