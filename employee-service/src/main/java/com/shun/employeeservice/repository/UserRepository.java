package com.shun.employeeservice.repository;

import com.shun.employeeservice.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Repository interface for User entity.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * <p>
     * Find a user by their email ID.
     * </p>
     *
     * @param emailId the email ID of the user
     * @return the user with the specified email ID, or null if not found
     */
    User findByEmailId(String emailId);

    /**
     * <p>
     * Find a user by their email ID and active status.
     * </p>
     *
     * @param emailId the email ID of the user
     * @return the user with the specified email ID, or null if not found
     */
    User findByEmailIdAndIsActiveTrue(String emailId);
}
