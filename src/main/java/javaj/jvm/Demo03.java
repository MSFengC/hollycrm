package javaj.jvm;

/**
 * test my user-define ClassLoader
 *
 * @author wangYuBai
 * @create 2018-10-01-21:09
 */
public class Demo03 {
    public static void main(String[] args) throws ClassNotFoundException {
        DiyClassLoader loader1 = new DiyClassLoader("F:/Demo02");
        DiyClassLoader loader2 = new DiyClassLoader("F:/Demo03");
        Class clazz1 = loader1.findClass("javaj.javassist.Emp");
        Class clazz2 = loader1.findClass("javaj.javassist.Emp");
        // Class clazz3 = loader2.findClass("javaj.javassist.Emp");
        // Class clazz4 = loader2.loadClass("java.lang.String");
        Class clazz5 = loader2.findClass("wang.yu.bai.Emp");

        System.out.println(clazz1.hashCode());
        System.out.println("-----------wangYuBai.com-----------clazz1.getClassLoader() value = " + clazz1.getClassLoader() + "," + "current class = Demo03.main()");
        System.out.println(clazz2.hashCode());
        System.out.println("-----------wangYuBai.com-----------clazz2.getClassLoader() value = " + clazz2.getClassLoader() + "," + "current class = Demo03.main()");
        // System.out.println(clazz3.hashCode());
        // System.out.println("-----------wangYuBai.com-----------clazz3.getClassLoader() value = " + clazz3.getClassLoader() + "," + "current class = Demo03.main()");
        System.out.println(clazz5.hashCode());
        System.out.println("-----------wangYuBai.com-----------clazz4.getClassLoader() value = " + clazz5.getClassLoader() + "," + "current class = Demo03.main()");
    }

    // public void testURLClassLoader()
}
