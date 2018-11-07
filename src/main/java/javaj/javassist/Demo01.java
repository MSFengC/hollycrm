package javaj.javassist;

import javassist.*;

/**
 * @author:feng
 * 利用javassist来进行字节码文件操作
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctclass = pool.makeClass("wang.yu.bai.Emp");

        //creater field
        //18/9/25 bug "private int empNumber" 后没加 ; 号
        CtField f1 = CtField.make("private int empNumber;", ctclass);
        CtField f2 = CtField.make("private String empName;", ctclass);

        ctclass.addField(f1);
        ctclass.addField(f2);

        //create method
        CtMethod m1 = CtMethod.make("public int getEmpNumber(){return empNumber;}", ctclass);
        CtMethod m2 = CtMethod.make("public void setEmpNumber(int empNumber){this.empNumber = empNumber;}", ctclass);

        ctclass.addMethod(m1);
        ctclass.addMethod(m2);

        //create constructor
        CtConstructor c1 = new CtConstructor(new CtClass[]{CtClass.intType, pool.get("java.lang.String")}, ctclass);
        c1.setBody("{this.empNumber = empNumber; this.empName = empName;}");
        ctclass.addConstructor(c1);

        ctclass.writeFile("c:/myjava");
        System.out.println("OK");
    }
}
