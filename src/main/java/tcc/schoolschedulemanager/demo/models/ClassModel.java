package tcc.schoolschedulemanager.demo.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "class")
public class ClassModel {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    //Curso da turma
    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseModel course;

    //Sigla da turma
    @Column(name = "acronym")
    private String acronym;

    //Horário

    //Professores
    @ManyToMany
    @JoinTable(name = "class_teachers",
        joinColumns = @JoinColumn(name = "class_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<UserModel> teachers = new ArrayList<>();

    // public ClassModel(UUID id, CourseModel course, String acronym, List<UserModel> teachers) {
    //     this.id = id;
    //     this.course = course;
    //     this.acronym = acronym;
    //     this.teachers = teachers;
    // }

    public ClassModel(String acronym, CourseModel courseMode) {
        this.acronym = acronym;
        this.course = courseMode;
    }

    public ClassModel() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public CourseModel getCourse() {
        return course;
    }

    public void setCourse(CourseModel course) {
        this.course = course;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public List<UserModel> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<UserModel> teachers) {
        this.teachers = teachers;
    }

    


}
