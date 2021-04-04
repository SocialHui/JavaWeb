import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class MaxCount extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        HttpSession session = request.getSession();
        writer.println(String.format("session的创建时间为：%s<p></p>",new Date(session.getCreationTime())));
        writer.println(String.format("session的最后访问时间为：%s<p></p>",new Date(session.getLastAccessedTime())));

        String session1 = "countkey";
        if (session.isNew() || session.getAttribute(session1) == null) {
            //代表是第一次访问，
            session.setAttribute(session1,1);
            writer.println(String.format("访问次数为：%d",1));
        } else {
            //不是第一次访问
            int count = (int)session.getAttribute(session1);
            count++;
            session.setAttribute(session1,count);
            writer.println(String.format("访问次数为：%d",count));
        }
    }
}
