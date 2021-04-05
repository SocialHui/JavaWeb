package dao;

import models.UserInfo;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserInfoDao {
    /**
     * 注册
     */
    public boolean add(UserInfo userInfo) throws SQLException {
        //获取连接
        boolean result = false;
        if (userInfo.getUsername() != null && userInfo.getPassword() != null) {
            Connection connection = DBUtils.getConnect();
            String sql = "insert into userinfo(username,passwors) values(?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,userInfo.getUsername());
            statement.setString(2,userInfo.getPassword());
            result = statement.executeUpdate() >= 1 ? true : false;
            DBUtils.close(connection,statement,null);
        }
        return result;
    }

    /**
     * 登录
     * @param userInfo
     * @return
     * @throws SQLException
     */
    public boolean isLogin(UserInfo userInfo) throws SQLException {
        boolean result = false;
        if (userInfo.getUsername() != null && userInfo.getPassword() != null) {
            Connection connection = DBUtils.getConnect();
            String sql = "select * from userinfo where username=?" +
                    "and passwors=? and state=1";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,userInfo.getUsername());
            statement.setString(2,userInfo.getPassword());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = true;
            }
        }
        return result;
    }
}
