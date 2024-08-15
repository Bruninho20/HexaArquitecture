package br.com.vwco.onedigitalplatform.cliente.infrastructure.security.jwt;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import br.com.vwco.onedigitalplatform.cliente.domain.model.User;
import br.com.vwco.onedigitalplatform.cliente.infrastructure.service.UserDetailsImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Value("${config.app.jwtSecret}")
    private String jwtSecret;

    @Value("${config.app.jwtExpirationMs}")
    private int accessTokenJwtExpirationMs;

    @Value("${config.app.jwtRefreshTokenExpirationMs}")
    private int refreshTokenJwtExpirationMs;

    public String generateAccessTokenJwt(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + accessTokenJwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .claim("is_access_token", true) 
                .compact();
    }

    public String generateRefreshTokenJwt(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + refreshTokenJwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public String refreshJwtToken(String refreshToken) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(refreshToken)
                    .getBody();

            String userEmail = claims.getSubject();
            UUID userId = UUID.fromString(claims.getId());
            String firstName = claims.get("firstName", String.class);

            User user = new User();
            user.setFirstName(firstName);
            user.setEmail(userEmail);

            UserDetailsImpl userDetails = UserDetailsImpl.build(user);

            return Jwts.builder()
                    .setSubject(userDetails.getEmail())
                    .setId(userDetails.getId().toString())
                    .claim("firstName", userDetails.getUsername())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date((new Date()).getTime() + refreshTokenJwtExpirationMs))
                    .signWith(SignatureAlgorithm.HS512, jwtSecret)
                    .compact();
        } catch (Exception e) {
            logger.error("Error refreshing JWT token: {}", e.getMessage());
            return null;
        }
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(authToken);
            logger.info("Token is valid: {}", authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        logger.info("Token is invalid: {}", authToken);
        return false;
    }

    public String getAuthenticatedUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        return userPrincipal.getEmail();
    }

    public Claims parseClaims(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Failed to parse claims from JWT: {}", e.getMessage());
            throw new IllegalArgumentException("Failed to parse claims from JWT", e);
        }
    }

    public boolean isAccessToken(String token) {
        Claims claims = parseClaims(token);
        Boolean isAccessToken = claims.get("is_access_token", Boolean.class);
        if (isAccessToken == null) {
            logger.warn("The claim 'is_access_token' is missing in the token: {}", token);
            return false;
        }
        return isAccessToken;
    }

}
