package tcc.schoolschedulemanager.demo.controllers.requests;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TeacherRequest {

    private Long id;
    private String name;
    private String registrationNumber;
    private String courses;
    private String availability;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedAt;
    
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
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCourses() {
        return courses;
    }
    public void setCourses(String courses) {
        this.courses = courses;
    }
    public String getAvailability() {
        return availability;
    }
    public void setAvailability(String availability) {
        this.availability = availability;
    }
    
    @Override
    public String toString() {
        return "TeacherRequest [id=" + id + ", name=" + name + ", registrationNumber=" + registrationNumber
                + ", courses=" + courses + ", availability=" + availability + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt + "]";
    }

        

}
