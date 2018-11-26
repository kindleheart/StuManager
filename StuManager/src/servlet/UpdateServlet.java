package servlet;

import model.Student;
import service.Impl.StuServiceImpl;
import service.StuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.ParameterDescriptor;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

/**
 * Created by kindleheart happily.
 */
@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String updateError = null;
        Pattern pattern = null;
        Student stu = (Student) request.getSession().getAttribute("student");

        //密码验证
        String oriPassword = request.getParameter("oripassword");
        String newPassword = request.getParameter("newpassword");
        String rePassword = request.getParameter("repassword");
        String password = stu.getPassword();
        if(!password.equals(oriPassword)) {
            updateError =  "Original password is wrong!";
        } else if(newPassword == null || newPassword.length() < 4 || newPassword.length() > 20) {
            updateError =  "Password should have at least 4 characters and at most 20 characters!";
        } else if(!newPassword.equals(rePassword)) {
            updateError = "Two passwords are not the same!";
        }
        checkError(updateError, request, response);

        //用户名验证
        String name = request.getParameter("name");
        if(name == null || name.trim().isEmpty()) {
            updateError = "Username must not be Empty!";
        } else if(name.length() > 16){
            updateError = "Username should have at most 16 characters!";
        }
        checkError(updateError, request, response);

        //年龄验证
        String ageStr = request.getParameter("age");
        pattern = Pattern.compile("[\\d]*");
        int age = 0;
        if(pattern.matcher(ageStr).matches()) {
            age = Integer.parseInt(ageStr);
            if(age < 0 || age > 150) {
                updateError =  "Age is wrong!";
            }
        } else {
            updateError =  "Age must be number!";
        }
        checkError(updateError, request, response);

        //qq验证
        String QQ = request.getParameter("qq");
        pattern = Pattern.compile("[\\d]{6,12}");
        if(!pattern.matcher(QQ).matches()) {
            updateError =  "QQ should have at least 6 numbers and at most 12 numbers!";
        }
        checkError(updateError, request, response);

        //email验证
        String Email = request.getParameter("email");
        pattern = Pattern.compile("[\\d]{6,12}@[a-zA-Z]*.com");
        if(!pattern.matcher(Email).matches()) {
            updateError =  "Email is wrong!";
        }
        checkError(updateError, request, response);

        //验证码验证
        String captcha = request.getParameter("captcha");
        String session_captcha = (String)request.getSession().getAttribute("session_captcha");
        if(!session_captcha.equals(captcha)) {
            updateError =  "Captcha is wrong!";
        }
        checkError(updateError, request, response);

        //introduction验证
        String introduction = request.getParameter("introduction");
        if(introduction.length() > 255) {
            updateError =  "introduction is too long!";
        }
        checkError(updateError, request, response);

        //数据无误，开始修改
        String scode = stu.getScode();
        Student student = new Student(name, scode, newPassword, age, QQ, Email, introduction);
        StuService stuService = new StuServiceImpl();
        try {
            stuService.update(student);
            student = stuService.findByScode(scode);
            request.getSession().setAttribute("student", student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("profile.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    private void checkError(String updateError, HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        if(updateError != null) {
            request.setAttribute("updateError", updateError);
            request.getRequestDispatcher("/update.jsp").forward(request, response);
        }
    }
}
