package model;
import java.io.Serializable;

public class AdminList implements Serializable{
    private String aname;
    private String apwd;
    private String auth;

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

    public String getAuth(){
        return auth;
    }
    public void setAuth(String auth){
        this.auth = auth;
    }
}
