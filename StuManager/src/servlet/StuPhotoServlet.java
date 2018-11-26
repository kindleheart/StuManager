package servlet;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;

public class StuPhotoServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = (Student) request.getSession().getAttribute("student");
		BufferedImage image = ImageIO.read(new FileInputStream(student.getPhoto()));
		ImageIO.write(image, "JPEG",  response.getOutputStream());
	}

}
