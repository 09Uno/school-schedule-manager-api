package tcc.schoolschedulemanager.demo.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import tcc.schoolschedulemanager.demo.models.CourseModel;
import tcc.schoolschedulemanager.demo.models.UserModel;

public class UserCourseRequest {
    
    @JsonProperty("user")
    private UserModel user;

    @JsonProperty("course")
    private CourseModel course;

    @JsonCreator
    public UserCourseRequest(@JsonProperty("user") String user_id, @JsonProperty("course") String course_id) {
        this.user = new UserModel(user_id);
        this.course = new CourseModel(course_id);
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public CourseModel getCourse() {
        return course;
    }

    public void setCourse(CourseModel course) {
        this.course = course;
    }

    
}
