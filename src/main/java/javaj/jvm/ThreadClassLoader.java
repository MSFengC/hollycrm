package javaj.jvm;

import javaj.javassist.Emp;

/**
 * test 上下文类加载器，来规避一些 双亲委托机制的加载器
 *
 * @author wangYuBai
 * @create 2018-10-03-21:11
 */
public class ThreadClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader clazz01 = Emp.class.getClassLoader();
        System.out.println(clazz01);

        ClassLoader clazz02 = Thread.currentThread().getContextClassLoader();
        System.out.println(clazz02);

        Thread.currentThread().setContextClassLoader(new DiyClassLoader("f:/Demo02"));
        System.out.println(Thread.currentThread().getContextClassLoader());

        Class<?> clazz = Thread.currentThread().getContextClassLoader().loadClass("javaj.javassist.Emp");
        System.out.println(clazz);
        // 这里还是 appClassLoader
        System.out.println(clazz.getClassLoader());
    }
}
