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


public class GradeStatisticSearchSev extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        DB db=new DB();
        //HttpSession session=request.getSession();
        String season=request.getParameter("season");
        String major=request.getParameter("major");
        String classid=request.getParameter("classid");
        String depart=request.getParameter("depart");
        String course=request.getParameter("course");
        JSONArray al=db.gradeStatisticSearch(season,major,classid,depart,course);
        PrintWriter out=response.getWriter();
        out.print(al);
        out.flush();
        out.close();
        //session.setAttribute("gradeStatisticSearch",al);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}