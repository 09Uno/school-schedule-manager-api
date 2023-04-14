package tcc.schoolschedulemanager.demo.config.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.security.core.userdetails.User;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import tcc.schoolschedulemanager.demo.models.UserModel;

@Component
public class JwtUtil {

  private static final String SECRET_KEY = "secret";
  private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // 10 hours

  public String generateToken(User user) {
    return Jwts
      .builder()
      .setSubject(user.getUsername())
      .setIssuedAt(new Date())
      .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
      .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
      .compact();
  }

  public String getUserToken(String token) {
    return Jwts
      .parser()
      .setSigningKey(SECRET_KEY)
      .parseClaimsJws(token)
      .getBody()
      .getSubject();
  }

  public boolean validateToken(String token, HttpServletRequest request) {  
    try {
      Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public String getSecretKey() {
    return SECRET_KEY;
  }
}
