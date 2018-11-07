package javaj.javassist;

import javassist.*;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author: feng
 * test javassist API
 */
public class Demo02 {
    public static void main(String[] args) throws Exception {
/*        ClassPool pool = ClassPool.getDefault();
        // get a class
        CtClass cc = pool.get("javaj.javassist.Emp");

        byte[] bytes = cc.toBytecode();
        System.out.println(Arrays.toString(bytes));
        System.out.println(cc.getSimpleName());
        System.out.println(cc.getSuperclass());
        System.out.println(cc.getInterfaces());*/

        System.out.println("test03");
        test01();
        test02();
        test03();
    }

    // test method
    public static void test01() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("javaj.javassist.Emp");

         // CtMethod m1 = CtMethod.make("public int add(int a, int b){return a+b;}", cc);
        CtMethod m2 = new CtMethod(CtClass.intType, "add", new CtClass[]{
            CtClass.intType, CtClass.intType}, cc);

        m2.setModifiers(Modifier.PUBLIC);
        m2.setBody("{System.out.println(\"Hello world!\"); return $1 + $2;}");

        cc.addMethod(m2);

        // reflect
        Class<Emp> clazz = (Class<Emp>) cc.toClass();
        Emp obj = clazz.newInstance();
        Method m3 = clazz.getDeclaredMethod("add", int.class, int.class);
        Object result = m3.invoke(obj, 3, 4);
        cc.writeFile("f:/Demo02");
        System.out.println(result);
    }

    public static void test02() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("javaj.javassist.Emp");

        CtMethod cm = cc.getDeclaredMethod("sayHello", null);
        cm.insertBefore("System.out.println(\"insertBefore\");");
        cm.insertAfter("System.out.println(\"insert After\");");
        cm.insertAt(24,"System.out.println(\"insert at 26\");");

        //reflect to invoke
        Class<Emp> clazz = (Class<Emp>) cc.toClass();
        Emp obj = clazz.newInstance();
        Method m3 = clazz.getDeclaredMethod("sayHello");
        Object result = m3.invoke(obj);
        System.out.println("-----------wangYuBai.com-----------result值=" + result + "," + "当前类=Demo02.test02()");
    }

    public static void test03() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("javaj.javassist.Emp");

        // CtField cf = CtField.make("praivet Object ob;", cc);
        CtField cf = new CtField(CtClass.intType, "empSalary", cc);
        cf.setModifiers(Modifier.PUBLIC);
        cc.addField(cf);

        cc.addMethod(CtNewMethod.getter("Lizhi", cf));

        cc.writeFile("f:/Demo02");
        System.out.println("OK");
    }
}
