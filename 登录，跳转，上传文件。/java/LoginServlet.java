import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();

        String username = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        int num = 0;
        if (username.equals("root") && pwd.equals("root")) {
            response.sendRedirect("https://www.baidu.com/");
           /* response.setStatus(301);
            response.setHeader("location","https://www.baidu.com/");*/
        } else {
            num =2;
            writer.println("{\"total\":"+num+"}");
        }
    }
}
