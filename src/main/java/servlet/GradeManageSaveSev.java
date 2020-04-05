package servlet;
import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import model.*;
import db.*;



public class GradeManageSaveSev extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        DB db=new DB();
        //HttpSession session=request.getSession();
        String sid=request.getParameter("sId");
        String sname=request.getParameter("sName");
        String depart=request.getParameter("depart");
        String major=request.getParameter("major");
        String classid=request.getParameter("classid");
        String course=request.getParameter("course");
        String season=request.getParameter("season");
        String grade=request.getParameter("grade");
        db.gradeManageSave(sid,sname,depart,major,classid,course,season,grade,false,false);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}