package javaj.mysql;

import java.sql.*;
import java.util.Random;

/**
 * test data time timestamp
 *
 * @author wangYuBai
 * @create 2018-10-18-22:53
 */
public class Demo07 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "hollycrm");
            /**
             * JDBC 默认自动提交
             */
            connection.setAutoCommit(false);
            String sql = "insert into emp (username, pwd, createTime, lastTime) values (?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setObject(1, "李志");
            ps.setObject(2, "fsf");
            for(int i = 0; i < 1000; i++) {
                int random = 1000000000+new Random().nextInt(1000000);
                ps.setObject(3, new Date(System.currentTimeMillis() - random));
                ps.setObject(4, new Timestamp(System.currentTimeMillis() - random));
                ps.execute();
            }
            System.out.println("insert a customer");
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != ps) {
                    ps.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != connection) {
                        connection.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
