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

  //faz a busca de todos os usuários no banco de dados usando paginação
  @Query("SELECT new tcc.schoolschedulemanager.demo.dto.UserDTO(u.id, u.name, u.registrationNumber, roles) FROM UserModel u JOIN u.roles roles")
  Page<UserDTO> findAllUsers(Pageable pageable);

  //faz a busca de usuários pelo nome no banco de dados usando paginação
  @Query("SELECT new tcc.schoolschedulemanager.demo.dto.UserDTO(u.id, u.name, u.registrationNumber, r) FROM UserModel u JOIN u.roles r WHERE u.name LIKE %?1%")
  Page<UserDTO> findByName(String name, Pageable pageable);

}
