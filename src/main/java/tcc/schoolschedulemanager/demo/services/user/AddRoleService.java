package tcc.schoolschedulemanager.demo.services.user;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcc.schoolschedulemanager.demo.models.RoleModel;
import tcc.schoolschedulemanager.demo.models.UserModel;
import tcc.schoolschedulemanager.demo.repositories.RoleRepository;
import tcc.schoolschedulemanager.demo.repositories.UserRepository;
import tcc.schoolschedulemanager.enums.RoleName;

//service para adicionar uma role a um usuário
@Service
public class AddRoleService {

  //injeção de dependência dos repositórios necessários
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  //método para adicionar uma role a um usuário
  public UserModel addRole(UserModel user, String role) {
    try {
      //verifica se o usuário existe e se a role existe
      Optional<UserModel> userExists = userRepository
        .findById(user.getId())
        .map(Optional::of)
        .orElseThrow(() -> new IllegalArgumentException("User not found"));

        //verifica se a role existe
      Optional<RoleModel> roleExists = roleRepository
        .findByName(RoleName.valueOf(role))
        .map(Optional::of)
        .orElseThrow(() -> new IllegalArgumentException("Role not registered"));

      //verifica se o usuário já possui a role
      if (userExists.get().getRoles().contains(roleExists.get())) {
        throw new RuntimeException(
          "This role has already been set for this user"
        );
      }

      //adiciona a role ao usuário
      List<RoleModel> roles = userExists.get().getRoles();
      roles.add(roleExists.get());
      userExists.get().setRoles(roles);

      //atualiza o usuário com a nova role
      return userRepository.save(userExists.get());

    } catch (RuntimeException e) {
      throw new RuntimeException(e + " error trying to add role");
    }
  }
}
