package servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.vcode.utils.VerifyCode;


public class CaptchaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建一个对象
		VerifyCode vc = new VerifyCode(); 
		//得到一张图片
		BufferedImage image = vc.getImage();
		//把验证码放到session里
		request.getSession().setAttribute("session_captcha", vc.getText());
		System.out.println(vc.getText());
		//输出这张图片
		VerifyCode.output(image, response.getOutputStream());
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
