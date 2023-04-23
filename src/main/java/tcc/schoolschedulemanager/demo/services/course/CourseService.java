package tcc.schoolschedulemanager.demo.services.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tcc.schoolschedulemanager.demo.models.CourseModel;
import tcc.schoolschedulemanager.demo.repositories.CourseRepository;

@Service
public class CourseService {

        @Autowired
        private final CourseRepository courseRepository;

        public CourseService(CourseRepository courseRepository) {
            this.courseRepository = courseRepository;
        }

        public CourseModel create(CourseModel course) {
            return courseRepository.save(course);
        }


}
