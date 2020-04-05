package model;
import java.io.Serializable;
public class CourseList implements Serializable{
    private String course;

    public String getCourse(){
        return course;
    }
    public void setCourse(String course){
        this.course = course;
    }

}
