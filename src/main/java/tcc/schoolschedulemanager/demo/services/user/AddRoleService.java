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

@Service
public class AddRoleService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  public UserModel addRole(UserModel user, String role) {
    try {
      Optional<UserModel> userExists = userRepository
        .findById(user.getId())
        .map(Optional::of)
        .orElseThrow(() -> new IllegalArgumentException("User not found"));

      Optional<RoleModel> roleExists = roleRepository
        .findByName(RoleName.valueOf(role))
        .map(Optional::of)
        .orElseThrow(() -> new IllegalArgumentException("Role not registered"));

      if (userExists.get().getRoles().contains(roleExists.get())) {
        throw new RuntimeException(
          "This role has already been set for this user"
        );
      }

      List<RoleModel> roles = userExists.get().getRoles();
      roles.add(roleExists.get());
      userExists.get().setRoles(roles);
      
      return userRepository.save(userExists.get());

    } catch (RuntimeException e) {
      throw new RuntimeException(e + " error trying to add role");
    }
  }
}
