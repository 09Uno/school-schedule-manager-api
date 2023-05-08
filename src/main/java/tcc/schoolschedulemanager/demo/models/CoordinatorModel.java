package tcc.schoolschedulemanager.demo.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Entidade que representa um coordenador e também o Model que representa a tabela de coordenadores no banco de dados
@Entity

//Anotação para definir o nome da tabela no banco de dados
@Table(name = "coordinators")
public class CoordinatorModel {

    //Anotação para definir que o atributo é uma chave primária
    @Id
    //Anotação para definir que o atributo é auto incrementado
    @GeneratedValue(strategy = GenerationType.AUTO)
    //Anotação para definir o nome da coluna no banco de dados
    @Column(name = "id")
    private UUID id;

    //Anotação para definir que o atributo é uma chave estrangeira OneToOne
    @OneToOne   
    @JoinColumn(name = "user_id")
    private UserModel userId;

    //Anotação para definir que o atributo é uma chave estrangeira ManyToOne
    @ManyToOne
    //Anotação para definir o nome da tabela de relacionamento no banco de dados
    @JoinTable(
        name = "coordinators_courses",
        joinColumns = @JoinColumn(name = "coordinator_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private CourseModel courseId;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserModel getUserId() {
        return userId;
    }

    public void setUserId(UserModel userId) {
        this.userId = userId;
    }

    public CourseModel getCourseId() {
        return courseId;
    }

    public void setCourseId(CourseModel courseId) {
        this.courseId = courseId;
    }

  
}
