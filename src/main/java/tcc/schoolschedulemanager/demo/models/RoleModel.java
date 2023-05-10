package tcc.schoolschedulemanager.demo.models;

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

    // essa linha define uma constante de classe chamada serialVersionUID com um valor numérico longo.
    // É usada para garantir a compatibilidade da classe serializável ao longo do tempo, permitindo que o mecanismo de 
    // serialização verifique se a versão da classe é a mesma usada quando os objetos serializados foram criados.
    private static final long serialVersionUID = 1L;

    // @Id define a chave primária
    @Id
    // @GeneratedValue define a estratégia de geração de valor para a chave primária
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    // @Column define o nome da coluna no banco de dados
    @Enumerated(EnumType.STRING)
    // @Column(name = "name", nullable = false, unique = true) define o nome da coluna no banco de dados, se é nulo e se é único
    @Column(name = "name", nullable = false, unique = true)
    private RoleName name;



    // retorna uma string que representa a autoridade do objeto atual, que é obtida a partir de seu nome convertido em uma string
    @Override
    public String getAuthority() {
        // TODO Auto-generated method stub
        return this.name.toString();    
    }



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
