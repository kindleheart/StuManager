package servlet;

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
@WebServlet(name = "CheckScodeServlet")
public class CheckScodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String scode = request.getParameter("scode");
        StuService stuService = new StuServiceImpl();
        try {
            boolean flag = stuService.checkScode(scode);
            response.getWriter().println(flag ? 1 : 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
