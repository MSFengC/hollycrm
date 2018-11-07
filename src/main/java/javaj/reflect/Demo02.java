package javaj.reflect;

import java.lang.reflect.*;

/**
 * @author :feng
 * 通过API动态操作类 的构造器，属性，方法
 */
public class Demo02 {
    public static void main(String[] args){
        String path = "javaj.reflect.A";
        try {
            Class<A> clazz = (Class<A>) Class.forName(path);
            A a = clazz.newInstance();

            //通过构造器 来 new 对象，但是不能调用一个 private 的构造器去 实例化 一个对象
            Constructor<A> constructor = clazz.getDeclaredConstructor(String.class);
            A a1 = constructor.newInstance("Hello");
            System.out.println(a1.getName());
            System.out.println(a);

            //通过 反射API 去调用方法，可以获取到 private 方法，但是不能使用，设置 setAccessible(true);
            A a2 = clazz.newInstance();
            Method method1 = clazz.getDeclaredMethod("setName", String.class);
            method1.invoke(a2, "wangyubai");
            Method method = clazz.getDeclaredMethod("getName");
            method.invoke(a2);

            //通过 反射API 操纵属性
            A a3 = clazz.newInstance();
            Field field = clazz.getDeclaredField("name");
            //可以获取到 private 属性，但是不能使用,field1.setAccessible(true);
            Field field1 = clazz.getDeclaredField("age");
            field1.setAccessible(true);
            System.out.println(field1);
            field1.set(a3, 12);
            field.set(a3, "白岩松");
            a3.getName();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
