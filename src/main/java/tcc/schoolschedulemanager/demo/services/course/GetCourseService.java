package tcc.schoolschedulemanager.demo.services.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tcc.schoolschedulemanager.demo.repositories.CourseRepository;

@Service
public class GetCourseService {
    
    @Autowired 
    private CourseRepository courseRepository;

    public GetCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    
    
}
