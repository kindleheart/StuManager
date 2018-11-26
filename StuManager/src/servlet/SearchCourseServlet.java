package servlet;

import model.Course;
import service.Impl.StuServiceImpl;
import service.StuService;
import util.TextUtils;

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
@WebServlet(name = "SearchCourseServlet")
public class SearchCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String number = request.getParameter("number");
        String canme = request.getParameter("cname");

        //如果没有输入数据
        if(TextUtils.isEmpty(number) && TextUtils.isEmpty(canme)) {
            request.setAttribute("searchError","Please input the value first!");
            request.getRequestDispatcher("CourseListServlet?currentPage=1").forward(request, response);
        }

        StuService stuService = new StuServiceImpl();
        try {
            List<Course> courseList = stuService.searchCourse(number, canme);
            //没有查询到课程
            if(courseList.size() == 0) {
                request.setAttribute("searchError","Don't have the course！");
                request.getRequestDispatcher("CourseListServlet?currentPage=1").forward(request, response);
            } else {
                //查询到课程，输出到Search、.jsp
                request.setAttribute("courseList", courseList);
                request.getRequestDispatcher("search.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
