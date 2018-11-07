package javaj.mysql;

import java.sql.*;

/**
 * test result set
 *
 * @author wangYuBai
 * @create 2018-10-15-22:33
 */
public class Demo04 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "hollycrm");
            String sql = "select * from emp where id > ?";
            ps = connection.prepareStatement(sql);
            ps.setObject(1, 0);

            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != rs) {
                    rs.close();
                }
            } catch (Exception e) {
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
}
