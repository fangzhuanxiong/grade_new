package servlet;
import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.ArrayList;
import model.*;
import db.*;
import org.json.JSONArray;


public class CheckUseradminSev extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        DB db=new DB();
        //HttpSession session=request.getSession();
        String aname=request.getParameter("aname");
        String apwd=request.getParameter("apwd");
        JSONArray al=new JSONArray();
        al=db.checkUseradmin(aname,apwd);
        PrintWriter out=response.getWriter();
        out.print(al);
        out.flush();
        out.close();
        //session.setAttribute("checkUseradmin",admin);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}