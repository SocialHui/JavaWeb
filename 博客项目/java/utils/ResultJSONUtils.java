package utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResultJSONUtils {
    //统一的输出
    public static void write(HttpServletResponse response, String jsonStr) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        writer.println(jsonStr);
    }
}
