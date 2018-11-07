package javaj.Rcompiler;
/**
 * @quthor:feng
 * 动态编译 main方法
 */

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;

public class Demo01 {
    public static void main(String[] args) throws Exception {
        String program = "public class Hello{public static void main(String[] args){System.out.println(\"Hello World\");}}";
        BufferedWriter bw = new BufferedWriter(new FileWriter("Hello.java"));
        bw.write(program);
        bw.flush();
        bw.close();
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, "Hello.java");
        System.out.println(result);

        //动态编译已经编译好了的类
        Runtime runtime = Runtime.getRuntime();
        //这里要用绝对路径
        Process process = runtime.exec("java -cp C:\\Users\\180913\\IdeaProjects\\test\\ Hello");
        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String str = "";
        while(null != (str=br.readLine())){
            System.out.println(str);
        }

        //利用反射调用main方法
        URL[] urls = new URL[]{new URL("file:/" + "C:/Users/180913/IdeaProjects/test/")};
        URLClassLoader loader = new URLClassLoader(urls);
        Class c = loader.loadClass("Hello");
        c.getDeclaredMethod("main", String[].class).invoke(null, (Object)new String[]{});
    }
}
