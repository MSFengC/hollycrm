package javaj.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * test regular expression
 *
 * @author wangYuBai
 * @create 2018-10-06-22:33
 */
public class Demo01 {

    static Pattern pattern = Pattern.compile("[0-9]");
    public static void main(String[] args) {
        Matcher m = pattern.matcher("aa123**asdf234**asdf234234");

        String str = m.replaceAll("&");
        System.out.println(str);

        String str01 = new String("asdf124dfsa235sa23");
        String[] array = str01.split("\\d+");

        for(String temp : array) {
            System.out.println(temp);
        }
    }
}
