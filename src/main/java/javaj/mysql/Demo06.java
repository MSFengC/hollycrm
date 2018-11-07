package javaj.mysql;

import java.sql.*;

/**
 * test 事务
 *
 * @author wangYuBai
 * @create 2018-10-17-22:54
 */
public class Demo06 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "hollycrm");
            /**
             * JDBC 默认自动提交
             */
            connection.setAutoCommit(false);
            String sql = "insert into emp (username, pwd) values (?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setObject(1, "李志");
            ps.setObject(2, "fsf");
            ps.execute();
            System.out.println("insert a customer");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ps2 = connection.prepareStatement("insert into emp (username, pwd) values (?, ?, ?)");
            ps2.setObject(1, "理智");
            ps2.setObject(2, "fsf");

            ps2.execute();
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
