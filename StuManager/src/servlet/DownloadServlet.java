package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by kindleheart happily.
 */
@WebServlet(name = "DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取要下载的文件名字 aa.jpg  --- inputStream
        String fileName = request.getParameter("filename");
        //2. 获取这个文件在tomcat里面的绝对路径地址
        String path = getServletContext().getRealPath("download/"+fileName);

        //让浏览器收到这份资源的时候， 以下载的方式提醒用户，而不是直接展示。
        response.setHeader("Content-Disposition", "attachment; filename="+fileName);

        //3. 转化成输入流
        InputStream is = new FileInputStream(path);
        OutputStream os = response.getOutputStream();

        int len = 0 ;
        byte[]buffer = new byte[1024];
        while( (len = is.read(buffer)) != -1){
            os.write(buffer, 0, len);
        }
        os.close();
        is.close();
    }
}
