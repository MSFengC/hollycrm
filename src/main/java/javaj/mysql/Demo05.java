package javaj.mysql;

import java.sql.*;

/**
 * test batch
 * 对于大量的批处理，建议使用Statement，因为Prepared Statement的预编译空间有限，当数量特别大时，会发生异常。
 *
 * @author wangYuBai
 * @create 2018-10-15-22:59
 */
public class Demo05 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            long startTime = System.currentTimeMillis();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "hollycrm");
            /**
             * connection 设置为手动提交
             */
            connection.setAutoCommit(false);
            st = connection.createStatement();

            for(int i = 0; i < 20; i++) {
                st.addBatch("insert into emp(username,pwd) values ('冯+"+i+"', 1024)");
            }

            st.executeBatch();
            connection.commit();
            long endTime = System.currentTimeMillis();

            System.out.println("-----------wangYuBai.com-----------耗时(startTime-endTime) value = " + (startTime-endTime) + "," + "current class = Demo05.main()");
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
                    if (null != st) {
                        st.close();
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
