package tcc.schoolschedulemanager.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tcc.schoolschedulemanager.demo.models.CourseModel;

import tcc.schoolschedulemanager.demo.services.course.CourseService;


//Controller para os cursos
@RestController
@RequestMapping("/api/course")
public class CourseController {
    

    @Autowired
    private CourseService courseService;


    @PostMapping("/create")
    public CourseModel create(@RequestBody CourseModel course) {
        return courseService.create(course);
    }

}
