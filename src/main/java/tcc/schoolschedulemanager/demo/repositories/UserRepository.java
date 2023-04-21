package tcc.schoolschedulemanager.demo.repositories;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tcc.schoolschedulemanager.demo.dto.UserDTO;
import tcc.schoolschedulemanager.demo.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
  Optional<UserModel> findByRegistrationNumber(String registrationNumber);

   @Query("SELECT new tcc.schoolschedulemanager.demo.dto.UserDTO(u.id, u.name, r.name, r.id) FROM UserModel u JOIN u.roles r")
   Page<UserDTO> findAllUsers(Pageable pageable);
}
