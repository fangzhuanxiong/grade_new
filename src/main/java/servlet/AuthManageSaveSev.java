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



public class AuthManageSaveSev extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        DB db=new DB();
        //HttpSession session=request.getSession();
        String name=request.getParameter("name");
        String auth1=request.getParameter("updateGradeAuth");
        String auth2=request.getParameter("changeOrDelGradeAuth");
        String auth3=request.getParameter("courseManageAuth");
        String auth4=request.getParameter("adminManageAuth");
        db.authManageSave(name,auth1,auth2,auth3,auth4,false);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}