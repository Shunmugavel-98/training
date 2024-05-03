package com.shun.employeeservice.util;

import com.shun.employeeservice.common.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

/**
 * <p>
 * Utility class for handling JWT operations.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
@Component
public class JwtUtils {

    // Secret key for JWT generation
    SecretKey secretKey = Keys.hmacShaKeyFor(Constants.MY_SECRET_KEY.getBytes());

    /**
     * <p>
     * Generates a JWT token for the given user.
     * </p>
     *
     * @param issuer the user for whom the token is generated
     * @param email the email of the user
     * @param role the role of the user
     * @return the JWT token as a string
     */
    public String generateJwt(String issuer, String email, String role) {
        long milliTime = System.currentTimeMillis();
        // 1 hour expiration
        long expiryTime = milliTime + 1000 * 60 * 60;
        return Jwts.builder()
                .setSubject(issuer)
                .setIssuedAt(new Date(milliTime))
                .setExpiration(new Date(expiryTime))
                .claim(Constants.EMAIL, email)
                .claim(Constants.ROLE, role)
                .signWith(secretKey).compact();
    }

    /**
     * <p>
     * Verifies the JWT token based on the provided authorization.
     * </p>
     *
     * Throws AccessDeniedException if verification fails.
     * @param authorization the JWT token to verify
     */
    public void verify(String authorization) throws RuntimeException {
        Jwts.parser().setSigningKey(secretKey).build().parseClaimsJws(authorization);
    }

    /**
     * <p>
     * Parse the JWT token based on the provided authorization.
     * </p>
     *
     * Throws AccessDeniedException if verification fails.
     * @param authorization the JWT token to verify
     * @return Claims the parsed jwt info
     */
    public Claims parseJwt(String authorization) {
        return Jwts.parser().setSigningKey(secretKey).build().parseClaimsJws(authorization).getBody();
    }
}
