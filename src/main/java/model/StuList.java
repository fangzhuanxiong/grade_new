package model;
import java.io.Serializable;

public class StuList implements Serializable{
    private String sid;
    private String sname;
    private String spwd;
    private String depart;
    private String major;
    private String classid;

    public String getSid(){
        return sid;
    }
    public void setSid(String sid){
        this.sid = sid;
    }

    public String getSname(){
        return sname;
    }
    public void setSname(String sname){
        this.sname = sname;
    }

    public String getSpwd(){
        return spwd;
    }
    public void setSpwd(String spwd){
        this.spwd = spwd;
    }

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
