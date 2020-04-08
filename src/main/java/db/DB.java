package db;
import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonValue;
import model.*;
import org.json.*;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.TimeZone;
import jxl.Sheet;
import jxl.Workbook;


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
    public JSONArray resultSetToJson4(ResultSet rs) throws SQLException, JSONException
    {
        ResultSetMetaData md = rs.getMetaData();// 获取表结构
        int num = md.getColumnCount();// 得到行的总数
        JSONArray array = new JSONArray();// json数组，根据下标找值；[{name1:wp},{name2:{name3:'ww'}}]name为key值，wp为value值
        // JSONArray array=JSONArray.fromObject(String);将String转换为JSONArray格式
        while (rs.next()) {// 如果结果集中有值
            JSONObject mapOfColValues = new JSONObject(new LinkedHashMap<>());// 创建json对象就是一个{name:wp}
            for (int i = 1; i <= num; i++) {
                mapOfColValues.put(md.getColumnName(i), rs.getObject(i));// 添加键值对，比如说{name:Wp}通过name找到wp
                mapOfColValues.put("usertype", 1);
                System.out.println(mapOfColValues.toString());
            }
            array.put(mapOfColValues);
        }
        return array;
    }
    public JSONArray resultSetToJson5(ResultSet rs) throws SQLException, JSONException
    {
        ResultSetMetaData md = rs.getMetaData();// 获取表结构
        int num = md.getColumnCount();// 得到行的总数
        JSONArray array = new JSONArray();// json数组，根据下标找值；[{name1:wp},{name2:{name3:'ww'}}]name为key值，wp为value值
        // JSONArray array=JSONArray.fromObject(String);将String转换为JSONArray格式
        while (rs.next()) {// 如果结果集中有值
            JSONObject mapOfColValues = new JSONObject(new LinkedHashMap<>());// 创建json对象就是一个{name:wp}
            for (int i = 1; i <= num; i++) {
                mapOfColValues.put(md.getColumnName(i), rs.getObject(i));// 添加键值对，比如说{name:Wp}通过name找到wp
                mapOfColValues.put("usertype", 2);
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

    public JSONArray login(String username,String password){    //sevdone
        try{
            pstmt=ct.prepareStatement("select * from stulist where sid=? and spwd=?");
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            ResultSet rs1=pstmt.executeQuery();
            while(rs1.next()){
                pstmt=ct.prepareStatement("select * from stulist where sid=? and spwd=?");
                pstmt.setString(1,username);
                pstmt.setString(2,password);
                ResultSet rs3=pstmt.executeQuery();
                JSONArray al1=new JSONArray();
                al1=resultSetToJson4(rs3);
                return al1;
            }
            pstmt=ct.prepareStatement("select * from adminlist where aname=? and apwd=?");
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            ResultSet rs2=pstmt.executeQuery();
            JSONArray al2=new JSONArray();
            al2=resultSetToJson5(rs2);
            return al2;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
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
            pstmt=ct.prepareStatement("select sum(case when grade<60 then 1 else 0 end) as 'to59',sum(case when grade between 60 and 69 then 1 else 0 end) as 'to69',sum(case when grade between 70 and 79 then 1 else 0 end) as 'to79',sum(case when grade between 80 and 89 then 1 else 0 end) as 'to89',sum(case when grade between 90 and 100 then 1 else 0 end) as 'to100',avg(grade) as avgGrade,max(grade) as maxGrade from GradeList,StuList where season=? and major=? and classid=? and depart=? and course=?");
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
            pstmt=ct.prepareStatement("select aname,updateGradeAuth,changeOrDelGradeAuth,courseManageAuth,adminManageAuth from AdminList");
            JSONArray al=new JSONArray();
            ResultSet rs=pstmt.executeQuery();
            al=resultSetToJson3(rs);
            return al;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public boolean deleteAuth(String name,boolean flag){    //sevdone
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

    public boolean authManageSave(String name,String updateGradeAuth,String changeOrDelGradeAuth,String courseManageAuth,String adminManageAuth,boolean flag){    //sevdone
        try{
            pstmt=ct.prepareStatement("select * from adminlist where aname=?");
            pstmt.setString(1,name);
            ResultSet rs1= pstmt.executeQuery();
            if(rs1.next()){
                pstmt=ct.prepareStatement("update adminlist set updateGradeAuth=?,changeOrDelGradeAuth=?,courseManageAuth=?,adminManageAuth=? where aname=?");
                pstmt.setString(1,updateGradeAuth);
                pstmt.setString(2,changeOrDelGradeAuth);
                pstmt.setString(3,courseManageAuth);
                pstmt.setString(4,adminManageAuth);
                pstmt.setString(5,name);
                pstmt.executeUpdate();
                return true;
            }
            else{
                pstmt=ct.prepareStatement("insert into adminlist(aname,apwd,updateGradeAuth,changeOrDelGradeAuth,courseManageAuth,adminManageAuth) values(?,123456,?,?,?,?)");
                pstmt.setString(1,name);
                pstmt.setString(2,updateGradeAuth);
                pstmt.setString(3,changeOrDelGradeAuth);
                pstmt.setString(4,courseManageAuth);
                pstmt.setString(5,adminManageAuth);
                pstmt.executeUpdate();
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public JSONArray getAuth(String username){
        try{
            pstmt=ct.prepareStatement("select updateGradeAuth,changeOrDelGradeAuth,courseManageAuth,adminManageAuth from adminlist where aname=? ");
            pstmt.setString(1,username);
            JSONArray al=new JSONArray();
            ResultSet rs=pstmt.executeQuery();
            al=resultSetToJson(rs);
            return al;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public JSONArray gradeManageSearch(String season,String major,String classid,String depart){
        try{    //sevdone
            pstmt=ct.prepareStatement("select StuList.sid,StuList.sname,StuList.depart,StuList.major,StuList.classid,GradeList.course,GradeList.season,GradeList.grade,GradeList.level from StuList,GradeList where StuList.sid=GradeList.sid and GradeList.season=? and StuList.major=? and StuList.classid=? and StuList.depart=?");
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
    public boolean gradeManageSave(String sid,String sname,String depart,String major,String classid,String course,String season,String grade,String level,boolean flag1,boolean flag2){
        try{    //sevdone
            pstmt=ct.prepareStatement("select * from gradelist where sid=? and course=? and season=?");
            pstmt.setString(1,sid);
            pstmt.setString(2,course);
            pstmt.setString(3,season);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()){
                pstmt=ct.prepareStatement("update gradelist set grade=?,level=? where sid=? and course=? and season=? ");
                pstmt.setString(1,grade);
                pstmt.setString(2,level);
                pstmt.setString(3,sid);
                pstmt.setString(4,course);
                pstmt.setString(5,season);
                pstmt.executeUpdate();
            }
            else{
                pstmt=ct.prepareStatement("insert into gradelist(sid, course, season, grade, level) values (?,?,?,?,?)");
                pstmt.setString(1,sid);
                pstmt.setString(2,course);
                pstmt.setString(3,season);
                pstmt.setString(4,grade);
                pstmt.setString(5,level);
                pstmt.executeUpdate();
            }

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
            pstmt=ct.prepareStatement("select sid from stulist where sid=?");
            pstmt.setString(1,userId);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()){
                pstmt=ct.prepareStatement("update stulist set spwd=? where sid=?");
                pstmt.setString(1,newPwd);
                pstmt.setString(2,userId);
                pstmt.executeUpdate();
                return true;
            }
            pstmt=ct.prepareStatement("update adminlist set apwd=? where aname=?");
            pstmt.setString(1,newPwd);
            pstmt.setString(2,userId);
            pstmt.executeUpdate();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean addFromExcel(){
        try {
            Workbook rwb=Workbook.getWorkbook(new File("F:\\gradeadd.xls"));
            Sheet rs=rwb.getSheet(0);//表
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    String sid=rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                    String course=rs.getCell(j++, i).getContents();
                    String season=rs.getCell(j++, i).getContents();
                    String grade=rs.getCell(j++, i).getContents();
                    String level=rs.getCell(j++, i).getContents();
                    pstmt=ct.prepareStatement("insert into gradelist(sid, course, season, grade, level) values (?,?,?,?,?)");
                    pstmt.setString(1,sid);
                    pstmt.setString(2,course);
                    pstmt.setString(3,season);
                    pstmt.setString(4,grade);
                    pstmt.setString(5,level);
                    pstmt.executeUpdate();
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
