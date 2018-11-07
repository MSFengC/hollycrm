package javaj.jvm;

/**
 * test JVM
 *
 * @author wangYuBai
 * @create 2018-10-01-17:39
 */
public class Demo01 {
    static {
        System.out.println("Demo01`s static code block");
    }
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        /*Class<W> clazz = (Class<W>) Class.forName("javaj.jvm.W");
        W w = clazz.newInstance();*/
        
        System.out.println("-----------wangYuBai.com-----------W_son.width value = " + W_son.width + "," + "current class = Demo01.main()");
    }
}

class W_father {
    static {
        System.out.println("W_father`s static code block");
    }
}

class W extends W_father{
    public static int width = 100;
    public static final int MAX = 100;

    static{
        System.out.println("W`s static code block");
    }

    public W(){
        System.out.println("hello jvm");
    }
}

class W_son extends W{
    static {
        System.out.println("W_son`s class static code");
    }
}

