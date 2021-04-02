import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyJumpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");

        PrintWriter writer = resp.getWriter();

        if ("root".equals(name) && "root".equals(pwd)) {
            resp.sendRedirect("https://www.baidu.com/");
        } else {
            writer.println("输入的用户名和密码错误");
        }
    }
}
