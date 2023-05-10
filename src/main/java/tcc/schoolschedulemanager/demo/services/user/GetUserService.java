package tcc.schoolschedulemanager.demo.services.user;


import java.util.Optional;
import java.util.UUID;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import tcc.schoolschedulemanager.demo.dto.UserDTO;
import tcc.schoolschedulemanager.demo.models.UserModel;
import tcc.schoolschedulemanager.demo.repositories.UserRepository;

//service para os usuários
@Service
public class GetUserService {

  @Autowired
  private  UserRepository userRepository;

  //método para listar todos os usuários
  public Page<UserDTO> getAll(Pageable pageable) {
    return userRepository.findAllUsers(pageable);
  }

  //método para buscar um usuário pelo id
  public UserDTO getById(UUID id){
    try {
        Optional<UserModel> user = userRepository.findById(id);
        if(!user.isPresent()){
            throw new IllegalArgumentException("User not found");
        }
        UserDTO response = new UserDTO(user.get().getId(), user.get().getName(), user.get().getRegistrationNumber(), user.get().getRoles());
        return response;
    
    } catch (RuntimeException e) {
        throw new RuntimeException("Error trying to get this user by id " + e);
    }
   
  }
  
  //método para buscar um usuário pelo nome, retorna uma lista de usuários com o nome buscado
  public Page<UserDTO> getByName(String body, Pageable pageable){

    JSONObject json = new JSONObject(body);
    String name = json.getString("body");
    try {

      Page<UserDTO> user = userRepository.findByName(name, pageable);
      if(user.isEmpty()){
        throw new IllegalArgumentException("User not found");
      }
      return user;

    } catch (Exception e) {
      throw new RuntimeException("Error trying to get this user by name " + e);
    }

  }

}
