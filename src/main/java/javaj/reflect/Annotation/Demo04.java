package javaj.reflect.Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;

/**
 * @author :feng
 * 通过反射来操作 注解
 */
public class Demo04 {
    public static void main(String[] args){
        try {
            Class<SaxStudent> clazz = (Class<SaxStudent>) Class.forName("javaj.reflect.Annotation.SaxStudent");

            //获取类的注解
            Annotation[] annotations = clazz.getAnnotations();
            for(Annotation temp : annotations){
                System.out.println(temp);
            }

            //获取类指定的 注解
            SaxTable saxTable = clazz.getAnnotation(SaxTable.class);
            System.out.println(saxTable.value());

            //获取属性的注解
            Field field = clazz.getDeclaredField("studentName");
            SaxField saxField = field.getAnnotation(SaxField.class);
            System.out.println(saxField.columName() + saxField.type() + saxField.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
