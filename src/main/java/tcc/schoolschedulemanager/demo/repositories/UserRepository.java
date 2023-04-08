package tcc.schoolschedulemanager.demo.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import tcc.schoolschedulemanager.demo.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID>{
    
    Optional<UserModel> findByRegistrationNumber(String registrationNumber);

}
