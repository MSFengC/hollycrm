package javaj.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * test mysql connection
 *
 * @author wangYuBai
 * @create 2018-10-07-21:46
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        long start = System.currentTimeMillis();
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "hollycrm");
        System.out.println(connection);
        long end = System.currentTimeMillis();
        System.out.println("connection time: " + (end-start));
    }
}
