package servlet;

import dao.StuDao;
import dao.impl.StuDaoImpl;
import model.Grade;
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
import java.util.List;

/**
 * Created by kindleheart happily.
 */
@WebServlet(name = "GradeServlet")
public class GradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = (Student) request.getSession().getAttribute("student");
        String scode = student.getScode();
        StuService stuService = new StuServiceImpl();
        try {
            List<Grade> gradeList =  stuService.showGrade(scode);
            request.setAttribute("gradeList", gradeList);
            request.getRequestDispatcher("/grade.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
