package tcc.schoolschedulemanager.demo.services.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tcc.schoolschedulemanager.demo.dto.CourseDTO;
import tcc.schoolschedulemanager.demo.dto.UserDTO;
import tcc.schoolschedulemanager.demo.models.CourseModel;
import tcc.schoolschedulemanager.demo.models.UserModel;
import tcc.schoolschedulemanager.demo.repositories.CourseRepository;
import tcc.schoolschedulemanager.demo.repositories.RoleRepository;
import tcc.schoolschedulemanager.demo.repositories.UserRepository;
import tcc.schoolschedulemanager.demo.requests.UserCourseRequest;
import tcc.schoolschedulemanager.enums.RoleName;

@Service
public class AddTeacherService {

    @Autowired
    private final CourseRepository courseRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final RoleRepository roleRepository;
    
    public AddTeacherService(CourseRepository courseRepository, UserRepository userRepository, RoleRepository roleRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public CourseDTO addTeacher(UserCourseRequest course_user) {

            //verifica se o usuário existe
            Optional<UserModel> userExists = userRepository.findById(course_user.getUser().getId())
            .map(Optional::of).orElseThrow(() -> new IllegalArgumentException("User not found"));
            
            //verifica se o usuário possui a role de um professor (ROLE_TEACHER)
            if(!userExists.get().getRoles().contains(roleRepository.findByName(RoleName.ROLE_TEACHER).get())) {
                throw new RuntimeException("This user is not a teacher");
            }

            //verifica se o curso existe
            Optional<CourseModel> courseExist = courseRepository.findById(course_user.getCourse().getId())
            .map(Optional::of).orElseThrow(() -> new IllegalArgumentException("Course not found"));

            //Verifica que se o professor já está cadastrado no curso
            if(courseExist.get().getTeachers().contains(userExists.get())) {
                throw new RuntimeException("This teacher is already registered in this course");
            }

            //Adiciona o professor ao curso
            List<UserModel> allTeaches = courseExist.get().getTeachers();
            allTeaches.add(userExists.get());

            courseRepository.save(courseExist.get());

            UserDTO coordinator = new UserDTO(userExists.get().getId(), userExists.get().getName(), userExists.get().getRegistrationNumber());
            List<UserDTO> teachers = new ArrayList<UserDTO>();
            for(UserModel u : allTeaches) {
                teachers.add(new UserDTO(u.getId(), u.getName(), u.getRegistrationNumber()));
            }


            CourseDTO courseDTO = new CourseDTO(courseExist.get().getId(), courseExist.get().getName(),courseExist.get().getAcronym(), courseExist.get().getDescription() ,coordinator, teachers);

            return courseDTO;




    }


}
