import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        //创建cookie
        Cookie cookie = new Cookie("username","java");

        //设置cookie的最大存活时间
        cookie.setMaxAge(60);

        //写入cookie
        resp.addCookie(cookie);

        Cookie cookie1 = new Cookie("pwd","pwd");
        resp.addCookie(cookie1);

        PrintWriter writer = resp.getWriter();
        writer.println("cookie写入成功");
    }
}
