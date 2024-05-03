package com.shun.employeeservice.config;

import com.shun.employeeservice.common.Constants;
import com.shun.employeeservice.exception.AccessDeniedException;
import com.shun.employeeservice.util.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * <p>
 * Filter class for processing JWT tokens in incoming HTTP requests.
 * This filter intercepts each request and validates the JWT token present in the request header.
 * If the token is valid, it extracts the user information and sets it in the security context.
 * </p>
 *
 * @author Shunmugavel - created on April 09, 2024
 */
@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    private JwtUtils jwtUtils = new JwtUtils();

    /**
     * <p>
     * This method is called by the filter chain to perform the actual filtering logic.
     * It verifies the JWT token in the request header, extracts the user information
     * and sets the authentication token in the security context.
     * </p>
     *
     * @param request      The HTTP servlet request.
     * @param response     The HTTP servlet response.
     * @param filterChain  The filter chain for invoking subsequent filters.
     * @throws IOException If any I/O errors occur.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {
        String authorization = request.getHeader(Constants.AUTHORIZATION);
        try {
            if (!(request.getRequestURI().contains(Constants.LOGIN_URL) || request.getRequestURI().contains(Constants.SIGN_UP_URL))) {
                jwtUtils.verify(authorization);
                String user = jwtUtils.parseJwt(authorization).getSubject();
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, null, null);
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            } else {
                SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(null, null, null));
            }
            filterChain.doFilter(request, response);
        } catch (Exception ex) {
            throw new AccessDeniedException(ex.getMessage());
        }
    }
}
