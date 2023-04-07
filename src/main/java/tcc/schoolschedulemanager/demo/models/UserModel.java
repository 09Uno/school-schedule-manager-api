package tcc.schoolschedulemanager.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;




@Entity
@Table(name = "users")
public class UserModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "registration_number")
  private String registrationNumber;

  @Column(name = "password")
  private String password;

  @JsonFormat(pattern = "dd/MM/yyyy")
  @Column(name = "created_at", updatable = false)
  private LocalDate createdAt;

  @Column(name = "updated_at")
  private LocalDate updatedAt;

  @Column(name = "role")
  @Enumerated(EnumType.STRING)
  private RoleEnum role;



  public enum RoleEnum {
    ADMIN,
    COORDINATOR,
    TEACHER,
    USER,
}

  public UserModel() {
  }

  public UserModel(String name, String registrationNumber, String password,   RoleEnum role) {
    this.name = name;
    this.registrationNumber = registrationNumber;
    this.password = password;
    this.role = role;
  }
  
public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public LocalDate getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDate getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDate updatedAt) {
    this.updatedAt = updatedAt;
  }

 

 

  public RoleEnum getRole() {
    return role;
  }

  public void setRole(RoleEnum role) {
    this.role = role;
  }

  
  @PrePersist //indica que o método será executado antes de persistir
  public void prePersist() {
    createdAt = LocalDate.now();
    role = RoleEnum.USER;
  }

}
