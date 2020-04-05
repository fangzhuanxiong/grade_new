package db;
import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonValue;
import model.*;
import org.json.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.TimeZone;

public class DB {
    private static final Object UTC= TimeZone.getTimeZone("UTC");
    Connection ct;
    PreparedStatement pstmt;
    String url;
    String user;
    String password;
    public DB(){
        url= "jdbc:mysql://localhost:3306/gbsdb?characterEncoding=UTF-8"+"&serverTimezone=UTC";
        user ="root";
        password ="123456";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            ct=DriverManager.getConnection(url,user,password);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public JSONArray resultSetToJson2(ResultSet rs) throws SQLException, JSONException
    {
        ResultSetMetaData md = rs.getMetaData();// 获取表结构
        int num = md.getColumnCount();// 得到行的总数
        JSONArray array = new JSONArray();// json数组，根据下标找值；[{name1:wp},{name2:{name3:'ww'}}]name为key值，wp为value值
        // JSONArray array=JSONArray.fromObject(String);将String转换为JSONArray格式
        while (rs.next()) {// 如果结果集中有值
            JSONObject mapOfColValues = new JSONObject(new LinkedHashMap<>());// 创建json对象就是一个{name:wp}
            for (int i = 1; i <= num; i++) {
                mapOfColValues.put(md.getColumnName(i), rs.getObject(i));// 添加键值对，比如说{name:Wp}通过name找到wp
                mapOfColValues.put("gradeEditor", false);
                mapOfColValues.put("newColumnEditor", false);
                System.out.println(mapOfColValues.toString());
            }
            array.put(mapOfColValues);
        }
        return array;
    }
    public JSONArray resultSetToJson3(ResultSet rs) throws SQLException, JSONException
    {
        ResultSetMetaData md = rs.getMetaData();// 获取表结构
        int num = md.getColumnCount();// 得到行的总数
        JSONArray array = new JSONArray();// json数组，根据下标找值；[{name1:wp},{name2:{name3:'ww'}}]name为key值，wp为value值
        // JSONArray array=JSONArray.fromObject(String);将String转换为JSONArray格式
        while (rs.next()) {// 如果结果集中有值
            JSONObject mapOfColValues = new JSONObject(new LinkedHashMap<>());// 创建json对象就是一个{name:wp}
            for (int i = 1; i <= num; i++) {
                mapOfColValues.put(md.getColumnName(i), rs.getObject(i));// 添加键值对，比如说{name:Wp}通过name找到wp
                mapOfColValues.put("newColumnEditor", false);
                System.out.println(mapOfColValues.toString());
            }
            array.put(mapOfColValues);
        }
        return array;
    }
    public JSONArray resultSetToJson(ResultSet rs) throws SQLException, JSONException
    {
        ResultSetMetaData md = rs.getMetaData();// 获取表结构
        int num = md.getColumnCount();// 得到行的总数
        JSONArray array = new JSONArray();// json数组，根据下标找值；[{name1:wp},{name2:{name3:'ww'}}]name为key值，wp为value值
        // JSONArray array=JSONArray.fromObject(String);将String转换为JSONArray格式
        while (rs.next()) {// 如果结果集中有值
            JSONObject mapOfColValues = new JSONObject(new LinkedHashMap<>());// 创建json对象就是一个{name:wp}
            for (int i = 1; i <= num; i++) {
                mapOfColValues.put(md.getColumnName(i), rs.getObject(i));// 添加键值对，比如说{name:Wp}通过name找到wp
                System.out.println(mapOfColValues.toString());
            }
            array.put(mapOfColValues);
        }
        return array;
    }

    public JSONArray checkUserstu(String sid,String spwd){    //sevdone
        try{
            pstmt=ct.prepareStatement("select * from stulist where sid=? and spwd=?");
            pstmt.setString(1,sid);
            pstmt.setString(2, spwd);
            ResultSet rs=pstmt.executeQuery();
            JSONArray al=new JSONArray();
            al=resultSetToJson(rs);
            return al;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public JSONArray checkUseradmin(String aname,String apwd){  //sevdone
        try{
            pstmt=ct.prepareStatement("select * from AdminList where aname=? and apwd=?");
            pstmt.setString(1,aname);
            pstmt.setString(2, apwd);
            ResultSet rs=pstmt.executeQuery();
            JSONArray al=new JSONArray();
            al=resultSetToJson(rs);
            return al;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public JSONArray gradeSearch(String season,String sid) {    //sevdone
        try{
            pstmt=ct.prepareStatement("select course,grade,level from GradeList where season=? and sid=?");
            pstmt.setString(1,season);
            pstmt.setString(2,sid);
            JSONArray al=new JSONArray();
            ResultSet rs=pstmt.executeQuery();
            al=resultSetToJson(rs);
            return al;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public JSONArray gradeStatisticSearch(String season,String major,String classid,String depart,String course){
        try{    //sevdone
            pstmt=ct.prepareStatement("select sum(case when grade<60 then 1 else 0 end) as '0-59',sum(case when grade between 60 and 69 then 1 else 0 end) as '60-79',sum(case when grade between 70 and 79 then 1 else 0 end) as '70-79',sum(case when grade between 80 and 89 then 1 else 0 end) as '80-89',sum(case when grade between 90 and 100 then 1 else 0 end) as '90-100' from GradeList,StuList where season=? and major=? and classid=? and depart=? and course=?");
            pstmt.setString(1,season);
            pstmt.setString(2,major);
            pstmt.setString(3,classid);
            pstmt.setString(4,depart);
            pstmt.setString(5,course);
            JSONArray al=new JSONArray();
            ResultSet rs=pstmt.executeQuery();
            al=resultSetToJson(rs);
            return al;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public JSONArray getAllCourse(){    //sevdone
        try{
            pstmt=ct.prepareStatement("select * from CourseList");
            JSONArray al=new JSONArray();
            ResultSet rs=pstmt.executeQuery();
            al=resultSetToJson2(rs);
            return al;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public boolean courseManageSave(String course){ //sevdone
        try{
            pstmt=ct.prepareStatement("insert into CourseList(course) values(?)");
            pstmt.setString(1,course);
            pstmt.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteCourse(String course){ //sevdone
        try{
            pstmt=ct.prepareStatement("delete from CourseList where course=?");
            pstmt.setString(1,course);
            pstmt.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public JSONArray authSearch(){  //sevdone
        try{
            pstmt=ct.prepareStatement("select aname,auth from AdminList");
            JSONArray al=new JSONArray();
            ResultSet rs=pstmt.executeQuery();
            al=resultSetToJson3(rs);
            return al;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public boolean deleteAuth(String name,String auth,boolean flag){    //sevdone
        try{
            pstmt=ct.prepareStatement("delete from AdminList where aname=?");
            pstmt.setString(1,name);
            pstmt.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean authManageSave(String name,String auth,boolean flag){    //sevdone
        try{
            pstmt=ct.prepareStatement("insert into AdminList(aname,auth) values(?,?)");
            pstmt.setString(1,name);
            pstmt.setString(2,auth);
            pstmt.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public JSONArray gradeManageSearch(String season,String major,String classid,String depart){
        try{    //sevdone
            pstmt=ct.prepareStatement("select sid,sname,depart,major,classid,course,season,grade from StuList,GradeList where season=? and major=? and classid=? and depart=?");
            pstmt.setString(1,season);
            pstmt.setString(2,major);
            pstmt.setString(3,classid);
            pstmt.setString(4,depart);
            JSONArray al=new JSONArray();
            ResultSet rs=pstmt.executeQuery();
            al=resultSetToJson2(rs);
            return al;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public boolean gradeManageSave(String sid,String sname,String depart,String major,String classid,String course,String season,String grade,boolean flag1,boolean flag2){
        try{    //sevdone
            pstmt=ct.prepareStatement("update GradeList set grade=? where sid=? and course=? and season=?");
            pstmt.setString(1,grade);
            pstmt.setString(2,sid);
            pstmt.setString(3,course);
            pstmt.setString(4,season);
            pstmt.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteGrade(String sid,String sname,String depart,String major,String classid,String course,String season,String grade,boolean flag1,boolean flag2){
        try{    //sevdone
            pstmt=ct.prepareStatement("delete from GradeList where sid=? and course=? and season=? and grade=?");
            pstmt.setString(1,sid);
            pstmt.setString(2,course);
            pstmt.setString(3,season);
            pstmt.setString(4,grade);
            pstmt.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public JSONArray getSeasonOptions(){    //sevdone
        try{
            pstmt=ct.prepareStatement("select DISTINCT season from GradeList");
            JSONArray al=new JSONArray();
            ResultSet rs=pstmt.executeQuery();
            al=resultSetToJson(rs);
            return al;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public JSONArray getDepartOptions(){    //sevdone
        try{
            pstmt=ct.prepareStatement("select DISTINCT depart from classList");
            JSONArray al=new JSONArray();
            ResultSet rs=pstmt.executeQuery();
            al=resultSetToJson(rs);
            return al;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public JSONArray getMajorOptions(String depart){    //sevdone
        try{
            pstmt=ct.prepareStatement("select DISTINCT major from classList where depart=?");
            pstmt.setString(1,depart);
            JSONArray al=new JSONArray();
            ResultSet rs=pstmt.executeQuery();
            al=resultSetToJson(rs);
            return al;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public JSONArray getClassOptions(String depart,String major){   //sevdone
        try{
            pstmt=ct.prepareStatement("select DISTINCT classid from classList where depart=? and major=?");
            pstmt.setString(1,depart);
            pstmt.setString(2,major);
            JSONArray al=new JSONArray();
            ResultSet rs=pstmt.executeQuery();
            al=resultSetToJson(rs);
            return al;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public boolean resetPwd(String userId,String newPwd){   //sevdone
        try{
            pstmt=ct.prepareStatement("update stulist set spwd=? where sid=? ");
            pstmt.setString(1,newPwd);
            pstmt.setString(2,userId);
            pstmt.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
