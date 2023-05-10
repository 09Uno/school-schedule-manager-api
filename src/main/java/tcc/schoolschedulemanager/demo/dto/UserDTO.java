package tcc.schoolschedulemanager.demo.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


import tcc.schoolschedulemanager.demo.models.RoleModel;
import tcc.schoolschedulemanager.enums.RoleName;


//DTO = Data Transfer Object - usado neste código para retornar os dados de um coordenador sem retornar todos os dados do usuario
public class UserDTO {
    
    private UUID id;
    private String name;
    private String registrationNumber;
    private List<RoleModel> roles = new ArrayList<>();

   


    //construtor para retornar os dados de um coordenador sem retornar todos os dados do usuario
    public UserDTO(UUID id, String name, String registrationNumber, RoleModel role) {
        this.id = id;
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.roles = Collections.singletonList(role);
    }

    
    
    public UserDTO(UUID id, String name, String registrationNumber) {
        this.id = id;
        this.name = name;
        this.registrationNumber = registrationNumber;
    }

    //construtor para retornar os dados de um coordenador sem retornar todos os dados do usuario 
    public UserDTO(UUID id, String name, String registrationNumber, List<RoleModel> roles) {
        this.id = id;
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.roles = roles;
    }

    public UserDTO(String name, String registrationNumber) {
        this.name = name;
        this.registrationNumber = registrationNumber;
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
    public List<RoleModel> getRoles() {
        return roles;
    }
    public void setRoles(List<RoleModel> roles) {
        this.roles = roles;
    }


    public String getRegistrationNumber() {
        return registrationNumber;
    }


    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    
}
