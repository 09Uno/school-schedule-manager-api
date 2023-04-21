package tcc.schoolschedulemanager.demo.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import tcc.schoolschedulemanager.enums.RoleName;

@Entity
@Table(name = "roles")
public class RoleModel implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false, unique = true)
    private RoleName name;




    @Override
    public String getAuthority() {
        // TODO Auto-generated method stub
        return this.name.toString();    
    }


    

    // public RoleModel(UUID id, RoleName name) {
    //     this.id = id;
    //     this.name = name;
    // }

    public RoleModel(RoleName role) {
        this.name = role;
    }
    
    public RoleModel() {
    }



    public RoleModel(UUID roleId) {
    }




    public RoleModel( RoleName role,UUID roleId ) {
        this.id = roleId;
        this.name = role;
    }




    public static long getSerialversionuid() {
        return serialVersionUID;
    }




    public UUID getId() {
        return id;
    }




    public void setId(UUID id) {
        this.id = id;
    }




    public RoleName getName() {
        return name;
    }




    public void setName(RoleName name) {
        this.name = name;
    }
    
}
