import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@MultipartConfig
public class MyFileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        //获取文件，文件在html中的名字是file
        Part img = request.getPart("file");
        //设置生成的文件名
        UUID uuid = UUID.randomUUID();
        //上传
        img.write("D:\\"+uuid+img.getSubmittedFileName());

        PrintWriter writer = response.getWriter();
        writer.println("上传成功");
    }
}
