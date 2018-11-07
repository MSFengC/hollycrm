package javaj.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author feng
 * 判断 开启和关闭 setAccessible()，是否会影响到程序运行的效率
 */
public class Demo03 {
    public final long number = 1000000000L;

    public static void main(String[] args) throws Exception {
        Demo03 demo03 = new Demo03();

        demo03.test01();
        demo03.test02();
        demo03.test03();
    }

    public void test01(){
        A a = new A();

        long startTime = System.currentTimeMillis();

        for(int i = 0; i < number; i++){
            a.getName();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("test01`s time:" + (endTime-startTime));
    }

    public void test02() throws Exception {
        A a = new A();
        Class clazz = a.getClass();
        Method method = clazz.getDeclaredMethod("getName", null);

        long startTime = System.currentTimeMillis();

        for(int i = 0; i < number; i++){
            method.invoke(a, null);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("test02`s time:" + (endTime-startTime));
    }

    public void test03() throws Exception {
        A a = new A();
        Class clazz = a.getClass();
        Method method = clazz.getDeclaredMethod("getName");
        method.setAccessible(true);

        long startTime = System.currentTimeMillis();

        for(int i = 0; i < number; i++){
            method.invoke(a, null);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("test03`s time:" + (endTime-startTime));
    }
}
