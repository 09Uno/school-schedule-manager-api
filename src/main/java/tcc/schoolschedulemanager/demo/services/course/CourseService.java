package tcc.schoolschedulemanager.demo.services.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tcc.schoolschedulemanager.demo.models.CourseModel;
import tcc.schoolschedulemanager.demo.repositories.CourseRepository;
//service para os cursos
@Service
public class CourseService {

         //injeção de dependência dos repositórios necessários       
        @Autowired
        private final CourseRepository courseRepository;

        //construtor da classe com os repositórios injetados
        public CourseService(CourseRepository courseRepository) {
            this.courseRepository = courseRepository;
        }

        //método para criar um curso
        public CourseModel create(CourseModel course) {
            return courseRepository.save(course);
        }


}
