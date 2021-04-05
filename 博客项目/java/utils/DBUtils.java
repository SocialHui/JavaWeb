package utils;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {

    private static MysqlDataSource dataSource = null;
    //对外提供connection对象
    public static Connection getConnect() throws SQLException {
        if (dataSource == null) {
            dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/blog2?charactionEncoding=utf-8&useSSL=true");
            dataSource.setUser("root");
            dataSource.setPassword("111111");
        }
        return dataSource.getConnection();
    }


    //提供统一的关闭方法
    public static void close(Connection connection,
                                PreparedStatement statement,
                                ResultSet resultSet) throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}
