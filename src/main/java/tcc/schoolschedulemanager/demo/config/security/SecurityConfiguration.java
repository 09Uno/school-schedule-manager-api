package tcc.schoolschedulemanager.demo.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http)
    throws Exception {
    http
      .httpBasic()
      .and()
      .authorizeRequests()
      .antMatchers("/api/register").permitAll() // Ignorar o endpoint de criação de usuários
      .antMatchers("/").permitAll() // Ignorar o endpoint de criação de usuários
      .anyRequest()
      .authenticated()
      .and()
      .csrf()
      .disable();

    return http.build();
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
}
