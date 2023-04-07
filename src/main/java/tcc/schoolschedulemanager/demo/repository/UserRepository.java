package tcc.schoolschedulemanager.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tcc.schoolschedulemanager.demo.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{
    
}