package tcc.schoolschedulemanager.demo.services.coordinator;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tcc.schoolschedulemanager.demo.models.CoordinatorModel;
import tcc.schoolschedulemanager.demo.models.UserModel;
import tcc.schoolschedulemanager.demo.repositories.CoordinatorRepository;
import tcc.schoolschedulemanager.demo.repositories.UserRepository;
import tcc.schoolschedulemanager.enums.RoleName;

@Service
public class CoordinatorService {
    
    @Autowired
    private final CoordinatorRepository coordinatorRepository;

    @Autowired
    private final UserRepository userRepository;

    public CoordinatorService(CoordinatorRepository coordinatorRepository, UserRepository userRepository) {
        this.coordinatorRepository = coordinatorRepository;
        this.userRepository = userRepository;
        
    }

    public CoordinatorModel create(CoordinatorModel coordinator) {

        String id = coordinator.getUserId().getId().toString();
        UUID userId = UUID.fromString(id.trim());

        try{
            Optional<UserModel> isCoordinator = userRepository.findById(userId)
            .map(Optional::of)
            .orElseThrow( () -> new IllegalArgumentException("User not found"));

            if(!isCoordinator.get().getRoles()
            .stream().anyMatch(
                role -> role.getName()
                .equals(RoleName.ROLE_COORDINATOR))){
                throw new IllegalArgumentException("This user is not a coordinator");
            }
            return coordinatorRepository.save(coordinator);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error trying to create this coordinator " + e);
        }
    }

}
