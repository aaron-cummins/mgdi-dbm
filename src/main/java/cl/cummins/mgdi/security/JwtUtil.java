package cl.cummins.mgdi.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtUtil {
    private static final int expireInMs = 8 * 60 * 1000;
    private final static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    private final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    public String generate(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuer("cl.cummins.mgdi")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expireInMs))
                .signWith(key)
                .compact();
    }
    public boolean validate(String token) {
        if (getUsername(token) != null && isExpired(token)) {
            logger.trace("Is valid", token);
            return true;
        }
        logger.trace("Is invalid", token);
        return false;
    }

    public String getUsername(String token)  {
        Claims claims = getClaims(token);
        if (claims != null){
        logger.trace("getUsername", token);
        return claims.getSubject();}
        return null;
    }

    public boolean isExpired(String token) {
        Claims claims = getClaims(token);
        logger.trace("isExpired" , token);
        return claims.getExpiration().after(new Date(System.currentTimeMillis()));
    }

    private Claims getClaims(String token) {
        //Jwts.parserBuilder().setSigningKey(key).
        Claims jwts = null;
        try {
            logger.trace("claims");
            jwts = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        } catch (SignatureException e) {
            logger.info("Invalid JWT signature.");
            logger.trace("Invalid JWT signature trace: {}", e);
        } catch (MalformedJwtException e) {
            logger.info("Invalid JWT token.");
            logger.trace("Invalid JWT token trace: {}", e);
        } catch (ExpiredJwtException e) {
            logger.info("Expired JWT token.");
            logger.trace("Expired JWT token trace: {}", e);
        } catch (UnsupportedJwtException e) {
            logger.info("Unsupported JWT token.");
            logger.trace("Unsupported JWT token trace: {}", e);
        } catch (IllegalArgumentException e) {
            logger.info("JWT token compact of handler are invalid.");
            logger.trace("JWT token compact of handler are invalid trace: {}", e);
        }
        System.out.println();
        return jwts;
    }



}
