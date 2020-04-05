package model;
import java.io.Serializable;

public class GradeList implements Serializable{
    private String sid;
    private String course;
    private String season;
    private String grade;
    private String level;

    public String getSid(){
        return sid;
    }
    public void setSid(String sid){
        this.sid = sid;
    }

    public String getCourse(){
        return course;
    }
    public void setCourse(String course){
        this.course = course;
    }

    public String getSeason(){
        return season;
    }
    public void setSeason(String season){
        this.season = season;
    }

    public String getGrade(){
        return grade;
    }
    public void setGrade(String grade){
        this.grade = grade;
    }

    public String getLevel(){
        return level;
    }
    public void setLevel(String level){
        this.level = level;
    }

}
