package tcc.schoolschedulemanager.demo.config.security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;


public class JwtFilter extends OncePerRequestFilter {

  @Autowired
  private JwtUtil jwtUtil;

  @Autowired
  private UserDetailSecurity userDetailSecurity;

  @Override
  protected void doFilterInternal(
    HttpServletRequest request,
    HttpServletResponse response,
    FilterChain filterChain
  ) throws ServletException, IOException {
    try {
      String jwt = getToken(request);
      if (jwt != null && jwtUtil.validateToken(jwt, request)) {
        String user = jwtUtil.getUserToken(jwt);
        UserDetails userDetails = userDetailSecurity.loadUserByUsername(user);
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
          userDetails,
          null,
          userDetails.getAuthorities()
        );
        auth.setDetails(
          new WebAuthenticationDetailsSource().buildDetails(request)
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
      }
    } catch (Exception e) {
      System.out.println(
        "Não foi possível setar a autenticação do usuário" + e.getMessage()
      );
    }
    filterChain.doFilter(request, response);
    // TODO Auto-generated method stub
  }

  private String getToken(HttpServletRequest request) {
    String token = request.getHeader("Authorization");
    if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
      return token.replace("Bearer ", "");
    }
    return null;
  }
}
