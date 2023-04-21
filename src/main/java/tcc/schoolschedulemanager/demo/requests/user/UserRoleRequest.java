package tcc.schoolschedulemanager.demo.requests.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import tcc.schoolschedulemanager.demo.models.UserModel;

public class UserRoleRequest {

  @JsonProperty("user")
  private UserModel user;

  @JsonProperty("role")
  private String role;

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
