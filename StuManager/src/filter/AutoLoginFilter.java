package filter;

import model.Student;
import service.Impl.StuServiceImpl;
import service.StuService;
import util.CookieUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by kindleheart happily.
 */
@WebFilter(filterName = "AutoLoginFilter")
public class AutoLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        Student student = (Student) request.getSession().getAttribute("student");
        if(student == null) {
            Cookie[] cookies = request.getCookies();
            Cookie cookie = CookieUtil.findCookie(cookies, "auto_login");
            if(cookie != null) {
                String value = cookie.getValue();
                String scode = value.split("#")[0];
                String password = value.split("#")[1];
                request.setAttribute("scode", scode);
                request.setAttribute("password", password);
            }
        } else {
            request.setAttribute("scode", student.getName());
            request.setAttribute("password", student.getPassword());
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
