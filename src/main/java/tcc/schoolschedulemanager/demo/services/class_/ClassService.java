package tcc.schoolschedulemanager.demo.services.class_;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tcc.schoolschedulemanager.demo.dto.ClassDTO;
import tcc.schoolschedulemanager.demo.dto.CourseDTO;
import tcc.schoolschedulemanager.demo.dto.UserDTO;
import tcc.schoolschedulemanager.demo.models.ClassModel;
import tcc.schoolschedulemanager.demo.models.CourseModel;
import tcc.schoolschedulemanager.demo.models.UserModel;
import tcc.schoolschedulemanager.demo.repositories.ClassRepository;
import tcc.schoolschedulemanager.demo.repositories.CourseRepository;


@Service
public class ClassService {
    
    @Autowired
    private ClassRepository classRepository;

    @Autowired 
    private CourseRepository courseRepository;

    private ClassService(ClassRepository classRepository, CourseRepository courseRepository) {
        this.classRepository = classRepository;
        this.courseRepository = courseRepository;
    }


    public ClassDTO create(ClassModel class_) {
        
        Optional<CourseModel> course = courseRepository.findById(class_.getCourse().getId())
        .map(Optional::of).orElseThrow(() -> new IllegalArgumentException("User not found"));
 
 
         List<UserDTO> coordinators = new ArrayList<>();
         for (UserModel userModel : course.get().getCoordinators()) {
             UserDTO userDTO = new UserDTO( userModel.getId(), userModel.getName(), userModel.getRegistrationNumber());
             coordinators.add(userDTO);
         }

         //Criar uma verificação para ver se o professor já está na lista de professores do curso

         //Criar uma verificação para ver se a turma já está na lista de turmas do curso

         //Mudar para fazer a busca de todos os professores da classe e não só os do curso
         List<UserDTO> teachers = new ArrayList<>();
         for (UserModel userModel : course.get().getTeachers()) {
             UserDTO userDTO = new UserDTO(userModel.getId(), userModel.getName(), userModel.getRegistrationNumber());
             teachers.add(userDTO);
         }
         
         CourseDTO courseInfo = new CourseDTO(course.get().getId(), course.get().getName(), course.get().getAcronym(), course.get().getDescription());
 
         ClassDTO classSaved = new ClassDTO(class_.getId(), class_.getAcronym() , courseInfo , coordinators, teachers);
         System.out.println(classSaved);
 
         classRepository.save(class_);
         return classSaved; 
 
    }

}
