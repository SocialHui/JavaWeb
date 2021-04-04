import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyAjax extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");

        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2  = Integer.parseInt(request.getParameter("num2"));

        int total = num1 + num2;
        PrintWriter writer = response.getWriter();
        writer.println("{\"total\":"+total+"}");
    }
}
