package javaj.regex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * spider url
 *
 * @author wangYuBai
 * @create 2018-10-07-10:25
 */
public class Spider {

    static Pattern pattern = Pattern.compile("<a.+?</a>");
    public static void main(String[] args) {
        StringBuilder sb = getUrl("https://www.163.com/");

        Matcher matcher = pattern.matcher(sb.toString());
        int number = 0;

        while(matcher.find()) {
            System.out.println(++number +": " + matcher.group());
        }
    }

    public static StringBuilder getUrl(String url) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        try {
            URL u = new URL(url);
            br = new BufferedReader(new InputStreamReader(u.openStream(), Charset.forName("GBK")));
            String temp = "";

            while (null != (temp=br.readLine())) {
                sb.append(temp);
                sb.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != br) {
                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return sb;
    }
}
