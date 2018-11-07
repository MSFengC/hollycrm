package javaj.jvm;

/**
 * test ClassLoader
 *
 * @author wangYuBai
 * @create 2018-10-01-19:40
 */
public class Demo02 {
    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

        //get java.class.path
        String[] pathArray = System.getProperty("java.class.path").split(";");
        for(String temp : pathArray){
            System.out.println(temp);
        }
    }
}
