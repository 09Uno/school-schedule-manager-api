package tcc.schoolschedulemanager.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
public class UserModel implements UserDetails {

  // essa linha define uma constante de classe chamada serialVersionUID com um valor numérico longo.
    // É usada para garantir a compatibilidade da classe serializável ao longo do tempo, permitindo que o mecanismo de 
    // serialização verifique se a versão da classe é a mesma usada quando os objetos serializados foram criados.
  private static final long serialVersionUID = 1L;

  // @Id define a chave primária
  @Id
  // @GeneratedValue define a estratégia de geração de valor para a chave primária
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "registration_number", nullable = false, unique = true)
  private String registrationNumber;

  @Column(name = "password", nullable = false)
  private String password;

  @JsonFormat(pattern = "dd/MM/yyyy")
  @Column(name = "created_at", updatable = false)
  private LocalDate createdAt;

  @Column(name = "updated_at")
  private LocalDate updatedAt;

  //@ManyToMany define um relacionamento muitos para muitos de usuários e roles
  @ManyToMany
  @JoinTable(
    name = "users_roles",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id")
  )
  private List<RoleModel> roles = new ArrayList<>();

    //CURSOS

    //TURMAS

    //Disciplinas

    //Horários


  //Construtor 
  public UserModel(String name, String registrationNumber, String password) {
    this.name = name;
    this.registrationNumber = registrationNumber;
    this.password = password;
  }
  
  //Construtor
  public UserModel(UUID id, String name, String registrationNumber, List<RoleModel> roles) {
    this.id = id;
    this.name = name;
    this.registrationNumber = registrationNumber;
    this.roles = roles;
  }

  //Construtor
  public UserModel(String idString) {
    this.id = UUID.fromString(idString);
  }
  
  //Construtor
  public UserModel() {}

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    // TODO Auto-generated method stub
    return this.roles = roles;
  }

  @Override
  public String getPassword() {
    // TODO Auto-generated method stub
    return this.password = password;
  }

  @Override
  public String getUsername() {
    // TODO Auto-generated method stub
    return this.registrationNumber = registrationNumber;
  }

  @Override
  public boolean isAccountNonExpired() {
    // TODO Auto-generated method 
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isEnabled() {
    // TODO Auto-generated method stub
    return true;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
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

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public List<RoleModel> getRoles() {
    return roles;
  }

  public void setRoles(List<RoleModel> roles) {
    this.roles = roles;
  }

  public void addRole(RoleModel role) {
    this.roles.add(role);
  }

  
  @Override
  public String toString() {
    return "UserModel [id=" + id + ", name=" + name + ", registrationNumber=" + registrationNumber + ", password="
        + password + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", roles=" + roles + "]";
  }


  // @PrePersist define um método que será executado antes de persistir a entidade no caso a data de criação
  @PrePersist
  public void prePersist() {
    final LocalDate now = LocalDate.now();
    createdAt = now;
  }
}
