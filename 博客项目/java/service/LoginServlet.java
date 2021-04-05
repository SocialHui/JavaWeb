package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.UserInfoDao;
import models.UserInfo;
import utils.ResultJSONUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * 登录
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int state = -1;
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");

        UserInfo  userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(pwd);

        UserInfoDao userInfoDao = new UserInfoDao();
        try {
            boolean res = userInfoDao.isLogin(userInfo);
            if (res) {
                state = 200;
            } else {
                state = 100;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        HashMap<String,Object> map = new HashMap<>();
        map.put("state",state);
        ObjectMapper mapper = new ObjectMapper();
        ResultJSONUtils.write(response,mapper.writeValueAsString(map));
    }
}
