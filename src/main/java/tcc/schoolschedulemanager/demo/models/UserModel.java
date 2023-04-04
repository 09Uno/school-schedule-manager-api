package tcc.schoolschedulemanager.demo.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name")
    private String name;

    @Column(name ="registration_number")
    private String registrationNumber;

    @Column(name ="password")
    private String password;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "created_at", updatable = false )
    private LocalDate createdAt;

    @Column(name ="updated_at")
    private LocalDate updatedAt;

    @Column(name ="is_coordinator")
    private boolean isCoordinator;
    
    public UserModel() {
    }

    public UserModel(Long id, String name, String registrationNumber, String password, LocalDate createdAt, LocalDate updatedAt) {
        this.id = id;
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.password = password;
        createdAt = createdAt;
        updatedAt = updatedAt;
    }

    public UserModel(String name, String registrationNumber, String password) {
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.password = password;
    }
    
    @PrePersist //indica que o método será executado antes de persistir
    public void prePersist() {
        createdAt = LocalDate.now();
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
        createdAt = createdAt;
    }
    public LocalDate getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDate updatedAt) {
        updatedAt = updatedAt;
    }

    public boolean isCoordinator() {
        return isCoordinator;
    }
    public void setCoordinator(boolean isCoordinator) {
        this.isCoordinator = isCoordinator;
    }
    @Override
    public String toString() {
        return "UserModel [id=" + id + ", name=" + name + ", registrationNumber=" + registrationNumber + ", password="
                + password + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", isCoordinator="
                + isCoordinator + "]";
    }

}
