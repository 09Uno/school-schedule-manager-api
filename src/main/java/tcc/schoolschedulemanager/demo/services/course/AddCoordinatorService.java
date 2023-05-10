package tcc.schoolschedulemanager.demo.services.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tcc.schoolschedulemanager.demo.dto.CourseDTO;
import tcc.schoolschedulemanager.demo.dto.UserDTO;
import tcc.schoolschedulemanager.demo.models.CourseModel;
import tcc.schoolschedulemanager.demo.models.UserModel;
import tcc.schoolschedulemanager.demo.repositories.CourseRepository;
import tcc.schoolschedulemanager.demo.repositories.RoleRepository;
import tcc.schoolschedulemanager.demo.repositories.UserRepository;
import tcc.schoolschedulemanager.demo.requests.UserCourseRequest;
import tcc.schoolschedulemanager.enums.RoleName;


@Service
public class AddCoordinatorService {



      //injeção de dependência dos repositórios necessários       
      @Autowired
      private final CourseRepository courseRepository;
      @Autowired
      private final UserRepository userRepository;
      @Autowired
      private final RoleRepository roleRepository;


      //construtor da classe com os repositórios injetados
        public AddCoordinatorService(CourseRepository courseRepository, UserRepository userRepository, RoleRepository roleRepository) {
            this.courseRepository = courseRepository;
            this.userRepository = userRepository;
            this.roleRepository = roleRepository;
        }

        //método para adicionar um coordenador a um curso
        public CourseDTO addCoordinator(UserCourseRequest course_user) {
            //verifica se o usuário existe
           Optional<UserModel> userExists = userRepository.findById(course_user.getUser().getId())
           .map(Optional::of).orElseThrow(() -> new IllegalArgumentException("User not found"));
        
            //verifica se o usuário possui a role de um coordenador (ROLE_COORDINATOR)
            if(!userExists.get().getRoles().contains(roleRepository.findByName(RoleName.ROLE_COORDINATOR).get())) {
                throw new RuntimeException("This user is not a coordinator");
            }

            //verifica se o curso existe
            Optional<CourseModel> courseExist = courseRepository.findById(course_user.getCourse().getId())
            .map(Optional::of).orElseThrow(() -> new IllegalArgumentException("Course not found"));
            
            //verifica se o curso já possui um coordenador
            if(!courseExist.get().getCoordinators().isEmpty()) {
                throw new RuntimeException("This course already has a coordinator");
            }

            //adiciona o coordenador ao curso
            List<UserModel> coordinatorsList = courseExist.get().getCoordinators();
            coordinatorsList.add(userExists.get());
            courseExist.get().setCoordinators(coordinatorsList);

            //atualiza o curso com o novo coordenador
            courseRepository.save(courseExist.get());

            //Instancia um novo UserDTO com o usuário(UserDTO) que foi adicionado como coordenador
            //isso evita que a resposta do Json mostre dados desnecessários e sensíveis
            UserDTO coordinator = new UserDTO(userExists.get().getId(), userExists.get().getName(), userExists.get().getRegistrationNumber());
            
            //retorna o curso com o novo coordenador
            CourseDTO courseDTO = new CourseDTO(courseExist.get().getId(), courseExist.get().getName(),courseExist.get().getAcronym(), courseExist.get().getDescription() , coordinator);

            return courseDTO;


      

        }
    }