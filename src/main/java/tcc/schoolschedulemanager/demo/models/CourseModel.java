package tcc.schoolschedulemanager.demo.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

//Entidade que representa um curso e também o Model que representa a tabela de cursos no banco de dados
@Entity
//Anotação para definir o nome da tabela no banco de dados
@Table(name = "courses")
public class CourseModel {
    
    //Anotação para definir que o atributo é uma chave primária
    @Id
    //Anotação para definir que o atributo é auto incrementado
    @GeneratedValue(strategy = GenerationType.AUTO)

    //Anotação para definir o nome da coluna no banco de dados
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;


    
    //Construtor da classe que recebe os atributos como parâmetro 
    public CourseModel(UUID id, String name) {
        this.id = id;
        this.name = name;
    }


    //Construtor da classe que recebe os atributos como parâmetro
    public CourseModel(String id) {
        this.id = UUID.fromString(id);
    }

    
    //Construtor da classe que não recebe parâmetros
    public CourseModel() {
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

    
   

}
