package tcc.schoolschedulemanager.demo.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import tcc.schoolschedulemanager.demo.models.RoleModel;
import tcc.schoolschedulemanager.enums.RoleName;

public interface RoleRepository extends JpaRepository<RoleModel, UUID> {
    
    @Query("SELECT r FROM roles r WHERE r.name = :name")
    Optional<RoleModel> findByName(@Param("name") RoleName roleUser);

}
