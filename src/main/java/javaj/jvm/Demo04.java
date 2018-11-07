package javaj.jvm;

/**
 * encode & decode class file
 *
 * @author wangYuBai
 * @create 2018-10-03-17:28
 */
public class Demo04 {
    public static void main(String[] args) throws Exception {
        DecodeClassLoader classLoader = new DecodeClassLoader("F:/Demo02");
        // 18/10/3 bug:原因是忘记 修改 被加密class file 的 package 了
        Class<?> clazz01 = classLoader.findClass("javaj.javassist.Emp");

        System.out.println(clazz01.getSimpleName());
        System.out.println(clazz01.getClassLoader());
    }
}
