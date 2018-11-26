package servlet;

import model.Student;
import service.Impl.StuServiceImpl;
import service.StuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by kindleheart happily.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String scode = request.getParameter("scode");
        String password = request.getParameter("password");
        StuService stuService = new StuServiceImpl();
        try {
            Student student = stuService.login(scode, password);
            if(student != null) {
                request.getSession().setAttribute("student", student);
                //用于显示账号信息
                Cookie cookie = new Cookie("auto_login",scode + "#" + password);
                cookie.setMaxAge(60 * 60 * 24 * 7);//设置7天有效期
                response.addCookie(cookie);
                //跳出框架
                PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<script>");
                out.println("window.open ('index.jsp', '_top')");//替换任何可加载的框架集
                out.println("</script>");
                out.println("</html>");
            } else {
                request.setAttribute("error", "Scode and password don't match!");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
