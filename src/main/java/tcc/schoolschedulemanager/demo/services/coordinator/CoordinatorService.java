package tcc.schoolschedulemanager.demo.services.coordinator;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tcc.schoolschedulemanager.demo.dto.CoordinatorDTO;
import tcc.schoolschedulemanager.demo.models.CoordinatorModel;
import tcc.schoolschedulemanager.demo.models.CourseModel;
import tcc.schoolschedulemanager.demo.models.UserModel;
import tcc.schoolschedulemanager.demo.repositories.CoordinatorRepository;
import tcc.schoolschedulemanager.demo.repositories.CourseRepository;
import tcc.schoolschedulemanager.demo.repositories.UserRepository;
import tcc.schoolschedulemanager.enums.RoleName;

//service para os coordenadores
@Service
public class CoordinatorService {
    
    //injeção de dependência dos repositórios necessários 
    @Autowired
    private final CoordinatorRepository coordinatorRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final CourseRepository courseRepository;

    //construtor da classe com os repositórios injetados
    public CoordinatorService(CoordinatorRepository coordinatorRepository, UserRepository userRepository, CourseRepository courseRepository) {
        this.coordinatorRepository = coordinatorRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }


    //método para criar um coordenador
    public CoordinatorDTO create(CoordinatorModel coordinator) {

        //pega o id do usuario e transforma em UUID
        String id = coordinator.getUserId().getId().toString();
        UUID userId = UUID.fromString(id.trim());

        try{
            //verifica se o usuario existe e se ele é um coordenador(ROLE_COORDINATOR)
            Optional<UserModel> isCoordinator = userRepository.findById(userId)
            .map(Optional::of)
            .orElseThrow( () -> new IllegalArgumentException("User not found"));

            if(!isCoordinator.get().getRoles()
            .stream().anyMatch(
                role -> role.getName()
                .equals(RoleName.ROLE_COORDINATOR))){
                throw new IllegalArgumentException("This user is not a coordinator");
            }

            //pega o id do curso e transforma em UUID
            String courseId = coordinator.getCourseId().getId().toString();
            UUID courseIdUUID = UUID.fromString(courseId.trim());

            //verifica se o curso existe no banco de dados
            Optional<CourseModel> isCourse = courseRepository.findById(courseIdUUID)
            .map(Optional::of)
            .orElseThrow( () -> new IllegalArgumentException("Course not found"));

            //salva o coordenador no banco de dados 
            coordinatorRepository.save(coordinator); 

            //retorna um DTO com os dados do coordenador
            CoordinatorDTO coordinatorDTO = new CoordinatorDTO(id, isCoordinator.get().getName(), isCoordinator.get().getRegistrationNumber(), isCourse.get().getName());
            return coordinatorDTO;
              

        } catch (RuntimeException e) {
            throw new RuntimeException("Error trying to create this coordinator " + e);
        }
    }

}
