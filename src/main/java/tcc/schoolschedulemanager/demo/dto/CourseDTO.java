package tcc.schoolschedulemanager.demo.dto;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import tcc.schoolschedulemanager.demo.models.CourseModel;
import tcc.schoolschedulemanager.demo.models.UserModel;


//DTO = Data Transfer Object - usado neste código para retornar os dados de um coordenador sem retornar todos os dados do usuario
public class CourseDTO {

    private UUID id;
    private String name;
    private String acronym;
    private String description;
    private List<UserDTO> coordinator;
    private List<UserDTO> teachers;
    

    //construtor para retornar os dados de um coordenador sem retornar todos os dados do usuario
    


    public CourseDTO(UUID id, String name, List<UserDTO> coordinator) {
        this.id = id;
        this.name = name;
        this.coordinator = coordinator;
    }


    public CourseDTO(UUID id, String name,String acronym, String description ,  UserDTO coordinator) {
        this.id = id;
        this.name = name;
        this.acronym = acronym;
        this.description = description;
        this.coordinator = List.of(coordinator);
    }

    public CourseDTO(UUID id, String name, String acronym, String description) {
        this.id = id;
        this.name = name;
        this.acronym = acronym;
        this.description = description;
    }
    


    public CourseDTO(UUID id, String name, String acronym, String description, UserDTO coordinators,
            List<UserDTO> teachers) {
        this.id = id;
        this.name = name;
        this.acronym = acronym;
        this.description = description;
        this.coordinator = List.of(coordinators);
        this.teachers = teachers;
    }


    public CourseDTO(CourseModel course) {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<UserDTO> getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(List<UserDTO> coordinator) {
        this.coordinator = coordinator;
    }


    public String getAcronym() {
        return acronym;
    }


    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public List<UserDTO> getTeachers() {
        return teachers;
    }


    public void setTeachers(List<UserDTO> teachers) {
        this.teachers = teachers;
    }


    
    
    
}
