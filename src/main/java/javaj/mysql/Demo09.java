package javaj.mysql;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;

/**
 * test text
 *
 * @author wangYuBai
 * @create 2018-10-22-22:35
 */
public class Demo09 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "hollycrm");
            ps = conn.prepareStatement("insert into emp(username, myinfo, pwd) values (?, ?, ?)");

            ps.setObject(1,"王余白");
            ps.setClob(2, new FileReader(new File("f:/hello.txt")));
            ps.setObject(3, "1024");
            ps.executeUpdate();
            System.out.println("OK");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
