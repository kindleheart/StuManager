package servlet;

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
import java.util.regex.Pattern;

/**
 * Created by kindleheart happily.
 */
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String registerError = null;
        Pattern pattern = null;

        //学号验证
        String scode = request.getParameter("scode");
        pattern = Pattern.compile("[\\d]{4,16}");
        if(scode == null || scode.trim().isEmpty()) {
            registerError =  "Scode must not be empty!";
        } else if(!pattern.matcher(scode).matches()) {
            registerError =  "Scode should have at least 4 numbers and at most 16 numbers!";
        } else {
            StuService stuService = new StuServiceImpl();
            try {
                boolean flag = stuService.checkScode(scode);
                if(flag) registerError = "Scode has been registered!";
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        checkError(registerError, request, response);

        //密码验证
        String password = request.getParameter("password");
        String rePassword = request.getParameter("repassword");
        if(password == null || password.length() < 4 || password.length() > 20) {
            registerError =  "Password should have at least 4 characters and at most 20 characters!";
        } else if(!password.equals(rePassword)) {
            registerError = "Two passwords are not the same!";
        }
        checkError(registerError, request, response);

        //用户名验证
        String name = request.getParameter("name");
        if(name == null || name.trim().isEmpty()) {
            registerError = "Username must not be Empty!";
        } else if(name.length() > 16){
            registerError = "Username should have at most 16 characters!";
        }
        checkError(registerError, request, response);

        //年龄验证
        String ageStr = request.getParameter("age");
        pattern = Pattern.compile("[\\d]*");
        int age = 0;
        if(pattern.matcher(ageStr).matches()) {
            age = Integer.parseInt(ageStr);
            if(age < 0 || age > 150) {
                registerError =  "Age is wrong!";
            }
        } else {
            registerError =  "Age must be number!";
        }
        checkError(registerError, request, response);

        //qq验证
        String QQ = request.getParameter("qq");
        pattern = Pattern.compile("[\\d]{6,12}");
        if(!pattern.matcher(QQ).matches()) {
            registerError =  "QQ should have at least 6 numbers and at most 12 numbers!";
        }
        checkError(registerError, request, response);

        //email验证
        String Email = request.getParameter("email");
        pattern = Pattern.compile("[\\d]{6,12}@[a-zA-Z]*.com");
        if(!pattern.matcher(Email).matches()) {
            registerError =  "Email is wrong!";
        }
        checkError(registerError, request, response);

        //验证码验证
        String captcha = request.getParameter("captcha");
        String session_captcha = (String)request.getSession().getAttribute("session_captcha");
        if(!session_captcha.equals(captcha)) {
            registerError =  "Captcha is wrong!";
        }
        checkError(registerError, request, response);

        //introduction验证
        String introduction = request.getParameter("introduction");
        if(introduction.length() > 255) {
            registerError =  "introduction is too long!";
        }
        checkError(registerError, request, response);

        //数据无误，开始注册
        Student student = new Student(name, scode, password, age, QQ, Email, introduction);
        StuService stuService = new StuServiceImpl();
        try {
            stuService.add(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.getWriter().print("<h1>注册成功</h1><a href='login.jsp'>去登入？</a>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private void checkError(String registerError, HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        if(registerError != null) {
            request.setAttribute("registerError", registerError);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
