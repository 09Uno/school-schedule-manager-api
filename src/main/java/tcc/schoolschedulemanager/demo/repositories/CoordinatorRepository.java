package tcc.schoolschedulemanager.demo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import tcc.schoolschedulemanager.demo.models.CoordinatorModel;


public interface CoordinatorRepository extends JpaRepository<CoordinatorModel, UUID>{
    
}
