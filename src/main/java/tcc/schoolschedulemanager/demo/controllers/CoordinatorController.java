package tcc.schoolschedulemanager.demo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tcc.schoolschedulemanager.demo.dto.CoordinatorDTO;
import tcc.schoolschedulemanager.demo.models.CoordinatorModel;
import tcc.schoolschedulemanager.demo.services.coordinator.CoordinatorService;



//Controller para os coordenadores
@RestController
@RequestMapping("/api/coordinator")
public class CoordinatorController {
    
    private final CoordinatorService coordinatorService;

    public CoordinatorController(CoordinatorService coordinatorService) {
        this.coordinatorService = coordinatorService;
    }

    @PostMapping("/create")
    public CoordinatorDTO create(@RequestBody CoordinatorModel coordinator) {
        return coordinatorService.create(coordinator);
    }

    


}
