package servlet;

import model.PageBean;
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
@WebServlet(name = "CourseListServlet")
public class CourseListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        System.out.println(currentPage);
        StuService stuService = new StuServiceImpl();
        try {
            PageBean pageBean = stuService.findCourseByPage(currentPage);
            request.setAttribute("pageBean", pageBean);
            request.getRequestDispatcher("/select.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
