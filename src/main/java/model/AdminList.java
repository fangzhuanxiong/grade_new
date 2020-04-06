package model;
import java.io.Serializable;

public class AdminList implements Serializable{
    private String aname;
    private String apwd;
    private String updateGradeAuth;
    private String changeOrDelGradeAuth;
    private String courseManageAuth;
    private String adminManageAuth;

    public String getAname(){
        return aname;
    }
    public void setAname(String aname){
        this.aname = aname;
    }

    public String getApwd(){
        return apwd;
    }
    public void setApwd(String apwd){
        this.apwd = apwd;
    }

    public String getupdateGradeAuth(){
        return updateGradeAuth;
    }
    public void setupdateGradeAuth(String updateGradeAuth){
        this.updateGradeAuth = updateGradeAuth;
    }

    public String getchangeOrDelGradeAuth(){
        return changeOrDelGradeAuth;
    }
    public void setchangeOrDelGradeAuth(String changeOrDelGradeAuth){
        this.changeOrDelGradeAuth = changeOrDelGradeAuth;
    }

    public String getcourseManageAuth(){
        return courseManageAuth;
    }
    public void setcourseManageAuth(String courseManageAuth){
        this.courseManageAuth = courseManageAuth;
    }

    public String getadminManageAuth(){
        return adminManageAuth;
    }
    public void setadminManageAuth(String adminManageAuth){
        this.adminManageAuth = adminManageAuth;
    }
}
