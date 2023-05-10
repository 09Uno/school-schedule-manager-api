package tcc.schoolschedulemanager.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.text.html.Option;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.ipc.http.HttpSender.Response;
import tcc.schoolschedulemanager.demo.dto.ClassDTO;
import tcc.schoolschedulemanager.demo.dto.UserDTO;
import tcc.schoolschedulemanager.demo.models.ClassModel;
import tcc.schoolschedulemanager.demo.models.CourseModel;
import tcc.schoolschedulemanager.demo.models.UserModel;
import tcc.schoolschedulemanager.demo.repositories.CourseRepository;
import tcc.schoolschedulemanager.demo.services.class_.ClassService;


@RestController
@RequestMapping("/api/class")
public class ClassController {
   

    @Autowired
    private ClassService classService;

    @Autowired
    private CourseRepository courseRepository;

    //Criar classe
    @PostMapping("/create")
    public ResponseEntity<ClassDTO> create(@RequestBody ClassModel class_) {
       
        return ResponseEntity.ok(classService.create(class_));

    }

    //Ver Professores da classe

    

}
