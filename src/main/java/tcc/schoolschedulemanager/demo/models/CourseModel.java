package tcc.schoolschedulemanager.demo.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import tcc.schoolschedulemanager.demo.dto.UserDTO;

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

    @Column(name = "description")
    private String description;

    @Column(name = "acronym")
    private String acronym;

    //RELACIONAMENTOS
    //MANY TO MANY
    //Coordenadores
    @ManyToMany
    @JoinTable(
        name = "courses_coordinators",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<UserModel> coordinators = new ArrayList<>();

    //Professores
    @ManyToMany
    @JoinTable(
        name = "courses_teachers",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<UserModel> teachers = new ArrayList<>();

    
    //TURMAS

    //Disciplinas

    //Horários


    //Construtor da classe que recebe os atributos como parâmetro 
    public CourseModel(UUID id, String name) {
        this.id = id;
        this.name = name;
    }


    public CourseModel(UUID id, String name, String description, String acronym) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.acronym = acronym;
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


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getAcronym() {
        return acronym;
    }


    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }


    public List<UserModel> getCoordinators() {
        return coordinators;
    }


    public void setCoordinators(List<UserModel> userModel) {
        this.coordinators = userModel;
    }


    public List<UserModel> getTeachers() {
        return teachers;
    }


    public void setTeachers(List<UserModel> teachers) {
        this.teachers = teachers;
    }

    
   

}
