package javaj.mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 取出时间段的时区
 *
 * @author wangYuBai
 * @create 2018-10-22-22:04
 */
public class Demo08 {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "hollycrm");
            ps = conn.prepareStatement("select * from emp where lastTime>? and lastTime<?");

            java.sql.Date start = new java.sql.Date(str("2018-10-07 09:18:04"));
            java.sql.Date end = new java.sql.Date(str("2018-10-18 22:59:18"));

            ps.setObject(1, start);
            ps.setObject(2, end);

            rs = ps.executeQuery();

            while(rs.next()) {
                System.out.println(rs.getInt("id") + "--" + rs.getString("username") + "--" + rs.getDate("lastTime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long str(String dateStr) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            return df.parse(dateStr).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
