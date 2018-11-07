package javaj.jsengine;


import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.List;

/**
 * @author :feng
 * javascript engine 的执行
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        //获取 engine
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");

        //define a variable
        engine.put("msg", "王余白 很李志");
        String str = "var user = {name:\"王余白\", age:18, school:\"太原师范学院\"};";
        str += "println(user.name)";

        //执行脚本
        engine.eval(str);
        engine.eval("msg = 'sxt is a good author';");
        System.out.println(engine.get("msg"));

        //define javascript function()
        engine.eval("function add(a, b){var result = a + b; return result;}");
        //invoke API
        Invocable jsInvoke = (Invocable)engine;
        //execute javascript`s function()
        Object result = jsInvoke.invokeFunction("add", new Object[]{11, 23});
        System.out.println(result);

        //import other java class
        String jsCode = "importPackage(java.util); var list = Arrays.asList(\"太原师范学院\",\"东大关小学\",\"火炬中学\");";
        engine.eval(jsCode);
        List<String> list2 = (List<String>) engine.get("list");
        for(String temp : list2){
            System.out.println(temp);
        }

        //execute a javascript .js
        URL url = Demo01.class.getClassLoader().getResource("a.js");
        FileReader fr = new FileReader(url.getPath());
        engine.eval(fr);
        fr.close();
    }
}
