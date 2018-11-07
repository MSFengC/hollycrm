package javaj.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * test statement
 *
 * @author wangYuBai
 * @create 2018-10-07-22:28
 */
public class Demo02 {
    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "hollycrm");
        Statement statement = connection.createStatement();

        String sql = "INSERT into emp (username,pwd) VALUES (\"王余白\", \"hollycrm\")";
        statement.execute(sql);
    }
}
