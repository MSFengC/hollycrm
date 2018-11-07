package javaj.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * author:feng
 * 获取 类 的属性，方法
 */
public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        String path = "javaj.reflect.A";
        Class c1 = Class.forName(path);

        //获取类的名字
        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());

        //获取类的属性
        Field[] fields = c1.getFields();
        //只能获取 public 属性
        System.out.println(fields.length);

        //获取所有的属性
        Field[] fields1 = c1.getDeclaredFields();
        System.out.println(fields1.length);
        for(Field temp : fields1){
            System.out.println(temp);
        }

        //获取 指定的属性值
        Field field = c1.getDeclaredField("name");
        System.out.println(field);

        //获取类的所有的公共方法，包括 父类 或者是 超父类 的公共方法
        Method[] methods = c1.getMethods();
        System.out.println(methods.length);
        for(Method temp : methods){
            System.out.println(temp);
        }

        //获取类的 所有声明过的方法
        Method[] methods1 = c1.getDeclaredMethods();
        System.out.println(methods1.length);
        for(Method temp : methods1){
            System.out.println(temp);
        }

        //获取类的 指定的 不带参数 方法
        Method method = c1.getDeclaredMethod("setPrivate");
        System.out.println(method);

        //获取类的 指定的 带参数的 方法
        Method method1 = c1.getDeclaredMethod("setName", String.class);
        System.out.println(method1);

        //获取 类的 构造方法
        Constructor constructor = c1.getConstructor();
        System.out.println(constructor);

        //获取所有的构造器
        Constructor[] constructors = c1.getDeclaredConstructors();
        System.out.println(constructors.length);
        for(Constructor temp : constructors){
            System.out.println(temp);
        }

        //获取指定的 构造器
        Constructor constructor1 = c1.getDeclaredConstructor(String.class);
        System.out.println(constructor1);
    }
}
