package javaj.javassist;

import javassist.*;

public class Demo03 {
    public static void main(String[] args) throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.makeClass("wang.yu.bai");

        CtField f1 = CtField.make("public String name;", ctClass);
        CtField f2 = CtField.make("public int age;", ctClass);

        ctClass.addField(f1);
        ctClass.addField(f2);

        CtMethod m1 = CtMethod.make("public void print(){System.out.println(\"王余白 不 李志\");}", ctClass);
        ctClass.addMethod(m1);

        CtConstructor c1 = new CtConstructor(new CtClass[]{classPool.get("java.lang.String"), CtClass.intType}, ctClass);
        c1.setBody("{this.name = name; this.age = age;}");
        ctClass.addConstructor(c1);

        ctClass.writeFile("f:/javassistTest");
        System.out.println("OK");
    }
}
