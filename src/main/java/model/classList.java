package model;
import java.io.Serializable;

public class classList implements Serializable{
    private String depart;
    private String major;
    private String classid;

    public String getDepart(){
        return depart;
    }
    public void setDepart(String depart){
        this.depart = depart;
    }

    public String getMajor(){
        return major;
    }
    public void setMajor(String major){
        this.major = major;
    }

    public String getClassid(){
        return classid;
    }
    public void setClassid(String classid){
        this.classid = classid;
    }
}
