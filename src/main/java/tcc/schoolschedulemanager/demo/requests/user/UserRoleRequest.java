package tcc.schoolschedulemanager.demo.requests.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import tcc.schoolschedulemanager.demo.models.UserModel;

public class UserRoleRequest {

  @JsonProperty("user")
  private UserModel user;

  @JsonProperty("role")
  private String role;

  public UserRoleRequest() {}

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
