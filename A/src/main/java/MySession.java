import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class MySession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        //在此之前默认用户信息是正确的
        //操作session 尝试从客户段获取一个session，如果失败，新创建一个session
        HttpSession session = request.getSession();

        PrintWriter writer = response.getWriter();

        String sessionId = session.getId();
        writer.println("<h1>欢迎</h1>");
        writer.println(String.format("sessionId:%s<p></p>",sessionId));

        writer.println(String.format("session的创建时间是：%s<p></p>", new Date(session.getCreationTime())));
        writer.println(String.format("session的最后访问时间是：%s",new Date(session.getLastAccessedTime())));

        //会话key值定义
        String sessionKey = "countKey";
         //判断当前会话信息session是否为新的会话信息,是不是第一次
        if (session.isNew() || session.getAttribute(sessionKey) == null) {
            //表示第一次使用会话信息
            session.setAttribute(sessionKey,1);
            writer.println("访问次数：1");
        } else {
            //不是第一次访问
            int count = (int)session.getAttribute(sessionKey);
            count++;
            //更新session信息
            session.setAttribute(sessionKey,count);
            writer.println(String.format("<p></p>访问次数:%d",count));
        }
    }
}
