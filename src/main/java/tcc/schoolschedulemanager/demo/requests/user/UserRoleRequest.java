package tcc.schoolschedulemanager.demo.requests.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import tcc.schoolschedulemanager.demo.models.UserModel;

//Modelo de requisição para o papel de um usuário, utilizada no RequestBody do método POST de UserRoleController
public class UserRoleRequest {

  //Definição de como o JSON deve ser recebido
  @JsonProperty("user")
  private UserModel user;

  @JsonProperty("role")
  private String role;

  //Construtor para o JSON para o papel de um usuário
  @JsonCreator
  public UserRoleRequest(@JsonProperty("user") String idString) {
    this.user = new UserModel(idString);
  }

  public UserRoleRequest() {}

  public UserRoleRequest(UserModel user) {
    this.user = user;
  }

  public UserRoleRequest(UserModel user, String role) {
    this.user = user;
    this.role = role;
  }

  public UserModel getUserReq() {
    return user;
  }

  public void setUserReq(UserModel user) {
    this.user = user;
  }

  public String getRoleReq() {
    return role;
  }

  public void setRoleReq(String role) {
    this.role = role;
  }
}
