package tcc.schoolschedulemanager.demo.dto;

import java.util.ArrayList;
import java.util.List;

import tcc.schoolschedulemanager.demo.models.CourseModel;
import tcc.schoolschedulemanager.demo.models.UserModel;


//DTO = Data Transfer Object - usado neste código para retornar os dados de um coordenador sem retornar todos os dados do usuario
public class CoordinatorDTO {

    private String id;
    private String name;
    private String registrationNumber;
    private String courseName;

    //construtor para retornar os dados de um coordenador sem retornar todos os dados do usuario
    public CoordinatorDTO(String id, String name, String registrationNumber, String courseName) {
        this.id = id;
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.courseName = courseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    
    
}
