package com.project4.BGMC.filter;

import com.project4.BGMC.config.context.CompanyContext;
import com.project4.BGMC.security.CustomUserDetailsService;
import com.project4.BGMC.security.JwtService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class CompanyFilter extends OncePerRequestFilter {
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtService jwtService;

    private final Map<String, String> companySchemaMap; // tenantMap is injected here

    private static final List<String> EXCLUDED_PATHS = Arrays.asList("/api/company/create", "/api/health","/api/v1/user/login");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        if (EXCLUDED_PATHS.contains(requestURI)) {
            filterChain.doFilter(request, response);
            return;
        }

        String tenantId = request.getHeader("X-Tenant-ID");

        if (tenantId == null || tenantId.isEmpty()) {
            throw new ServletException("Missing X-Tenant-ID header");
        }

        if (companySchemaMap.containsKey(tenantId)) {
            CompanyContext.setCompanySchema(companySchemaMap.get(tenantId));
        } else {
            throw new ServletException("Bad X-Tenant-ID header");

        }

        try {
            String authorizationHeader = request.getHeader("Authorization");
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                String token = authorizationHeader.substring(7);
                try {
                    String username = jwtService.extractUsername(token);
                    UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
                    if (jwtService.validateToken(token, userDetails)) {
                        Claims claims = jwtService.extractAllClaims(token);
                        String tokenName = claims.get("tokenName", String.class);
                        if (tokenName.equalsIgnoreCase("accessToken")) {
                            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                        } else {
                            throw new RuntimeException("Unauthorised !!");
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Invalid Token");
                }
            }
            filterChain.doFilter(request, response);
        } finally {
            CompanyContext.clearCompanySchema();
        }


    }
}
