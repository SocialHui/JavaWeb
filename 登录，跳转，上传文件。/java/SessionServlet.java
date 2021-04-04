import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        HttpSession session = request.getSession();

        String sessionKey = "hello";
        if (session.isNew() || session.getAttribute(sessionKey) == null) {
            session.setAttribute(sessionKey,1);
            writer.println("访问次数：1");
        } else {
            int count = (int)session.getAttribute(sessionKey);
            count++;
            session.setAttribute(sessionKey,count);
            writer.println("访问次数:"+count);
        }
    }
}
