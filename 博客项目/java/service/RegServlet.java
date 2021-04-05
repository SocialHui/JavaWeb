package service;

import dao.UserInfoDao;
import models.UserInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import utils.ResultJSONUtils;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

public class RegServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    /**
     * 注册账户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");*/
        //String msg = "";

        int state = -1;

        //接受前端参数
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        //PrintWriter writer = response.getWriter();

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(pwd);

        UserInfoDao userInfoDao = new UserInfoDao();
        try {
            boolean res = userInfoDao.add(userInfo);
            if (res) {
                state = 200;
            } else {
                state = 100;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        /*HashMap<String,Object> map = new HashMap<>();
        map.put("state",state);
        ObjectMa*/
        //writer.println("{\"state\":"+state+",\"msg\":\""+msg+"\"}");

        //注意使用jackson要引入配置！！！！！
        HashMap<String,Object> map = new HashMap<>();
        map.put("state",state);
        ObjectMapper mapper = new ObjectMapper();
        ResultJSONUtils.write(response,mapper.writeValueAsString(map));
        //writer.println(mapper.writeValueAsString(map));
    }
}
