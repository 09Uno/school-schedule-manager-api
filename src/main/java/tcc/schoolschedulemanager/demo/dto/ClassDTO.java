package tcc.schoolschedulemanager.demo.dto;

import java.util.List;
import java.util.UUID;

import tcc.schoolschedulemanager.demo.models.CourseModel;

public class ClassDTO {

    private UUID id;
    private String acronym;
    
    private CourseDTO course;
   ;


    private List<UserDTO> coordinators;
    private List<UserDTO> teachers;



    public ClassDTO(UUID id, String acronym, CourseDTO course) {
        this.id = id;
        this.acronym = acronym;
        this.course = course;
    }

   

    public ClassDTO(UUID id, String acronym, CourseDTO course, List<UserDTO> coordinators, List<UserDTO> teachers) {
        this.id = id;
        this.acronym = acronym;
        this.course = course;
        this.coordinators = coordinators;
        this.teachers = teachers; 

    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public CourseDTO getCourse() {
        return course;
    }

    public void setCourse(CourseDTO course) {
        this.course = course;
    }

    public List<UserDTO> getCoordinators() {
        return coordinators;
    }

    public void setCoordinators(List<UserDTO> coordinators) {
        this.coordinators = coordinators;
    }

    public List<UserDTO> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<UserDTO> teachers) {
        this.teachers = teachers;
    }



    
    
}
