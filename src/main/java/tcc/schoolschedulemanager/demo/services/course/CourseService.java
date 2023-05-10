package tcc.schoolschedulemanager.demo.services.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tcc.schoolschedulemanager.demo.models.CourseModel;
import tcc.schoolschedulemanager.demo.repositories.CourseRepository;
import tcc.schoolschedulemanager.demo.repositories.RoleRepository;
import tcc.schoolschedulemanager.demo.repositories.UserRepository;
//service para os cursos
@Service
public class CourseService {

         //injeção de dependência dos repositórios necessários       
        @Autowired
        private final CourseRepository courseRepository;
        @Autowired
        private final UserRepository userRepository;
        @Autowired
        private final RoleRepository roleRepository;


        //construtor da classe com os repositórios injetados
        public CourseService(CourseRepository courseRepository, UserRepository userRepository, RoleRepository roleRepository) {
            this.courseRepository = courseRepository;
            this.userRepository = userRepository;
            this.roleRepository = roleRepository;
        }

        //método para criar um curso
        public CourseModel create(CourseModel course) {
            return courseRepository.save(course);
        }

        

      

        


}
