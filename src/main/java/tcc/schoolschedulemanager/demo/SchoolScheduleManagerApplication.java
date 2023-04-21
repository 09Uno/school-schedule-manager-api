package tcc.schoolschedulemanager.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@SpringBootApplication
@EntityScan(basePackages = {"tcc.schoolschedulemanager.demo.models"})
public class SchoolScheduleManagerApplication {

  @RequestMapping("/")
  public String home() {
    return "Hello World!";
  }

  public static void main(String[] args) {
    SpringApplication.run(SchoolScheduleManagerApplication.class, args);
  }
}
