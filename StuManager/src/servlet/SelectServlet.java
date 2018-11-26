package servlet;

import model.PageBean;
import model.Student;
import service.Impl.StuServiceImpl;
import service.StuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by kindleheart happily.
 */
@WebServlet(name = "SelectServlet")
public class SelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String number = request.getParameter("number");
        Student student = (Student) request.getSession().getAttribute("student");
        String scode = student.getScode();
        StuService stuService = new StuServiceImpl();
        try {
            if(stuService.selectCourse(scode, number)) {
                response.getWriter().println(1);
            } else {
                response.getWriter().println(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
