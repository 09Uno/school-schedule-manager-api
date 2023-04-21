package tcc.schoolschedulemanager.demo.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import tcc.schoolschedulemanager.demo.models.RoleModel;
import tcc.schoolschedulemanager.enums.RoleName;

public class UserDTO {
    
    private UUID id;
    private String name;
    private List<RoleModel> roles = new ArrayList<>();

    public UserDTO(UUID id, String name, RoleName role, UUID roleId) {
        this.id = id;
        this.name = name;
        this.roles = new ArrayList<>();
        this.roles.add(new RoleModel(role, roleId));    
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


}
