package tcc.schoolschedulemanager.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tcc.schoolschedulemanager.demo.dto.CourseDTO;
import tcc.schoolschedulemanager.demo.models.CourseModel;
import tcc.schoolschedulemanager.demo.requests.UserCourseRequest;
import tcc.schoolschedulemanager.demo.services.course.CourseService;
import tcc.schoolschedulemanager.demo.services.course.AddCoordinatorService;
import tcc.schoolschedulemanager.demo.services.course.AddTeacherService;


//Controller para os cursos
@RestController
@RequestMapping("/api/course")
public class CourseController {
    

    @Autowired
    private CourseService courseService;
    
    @Autowired
    private AddCoordinatorService addCoordinatorService;

    @Autowired
    private AddTeacherService addTeacherService;

    @PostMapping("/create")
    public CourseModel create(@RequestBody CourseModel course) {
        return courseService.create(course);
    }

    @PutMapping("/add-coordinator")
    public CourseDTO addCoordinator(@RequestBody UserCourseRequest course_user) {
         return addCoordinatorService.addCoordinator(course_user);
    }

    @PutMapping("/add-teachers")
    public CourseDTO addTeachers(@RequestBody UserCourseRequest course_user) {
        return addTeacherService.addTeacher(course_user);
    }  

    //get all courses

    //get course by id

    //get course by name

    //get course by coordinator

    //get course by teacher

}
