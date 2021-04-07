import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SetCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置两个基础的属性
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        //给客户端写入Cookie
        Cookie nameCookie = new Cookie("username","java");

        //给Cookie设置最大存活时间
        nameCookie.setMaxAge(60);
        //将Cookie写入到客户端
        response.addCookie(nameCookie);

        Cookie pwd = new Cookie("pwd","root");
        //设置为-1 代表cookie永不过期
        pwd.setMaxAge(-1);

        //多个cookie存储
        response.addCookie(pwd);

        PrintWriter writer = response.getWriter();
        writer.println("Cookie写入成功");
    }
}
