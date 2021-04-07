import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Calc extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受数据
        Integer num1 = Integer.parseInt(req.getParameter("number1"));
        Integer num2 = Integer.parseInt(req.getParameter("number2"));
        Integer total = num1+num2;

        //设置编码格式
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");

        //得到输出对象
        PrintWriter writer = resp.getWriter();
        writer.println("计算结果为："+total);
    }
}
