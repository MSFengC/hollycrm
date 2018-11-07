package javaj.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * test prepareStatement
 *
 * @author wangYuBai
 * @create 2018-10-07-22:44
 */
public class Demo03 {
    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "hollycrm");
        String sql = "insert into emp (username, pwd) values (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"王小波");
        preparedStatement.setString(2,"helloman");
        preparedStatement.setObject(1, "余华");

        preparedStatement.execute();
        System.out.println(preparedStatement.executeUpdate());
    }
}
