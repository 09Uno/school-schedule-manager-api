package tcc.schoolschedulemanager.demo.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import tcc.schoolschedulemanager.demo.models.ClassModel;

public interface ClassRepository extends JpaRepository<ClassModel, UUID>{
    
}
