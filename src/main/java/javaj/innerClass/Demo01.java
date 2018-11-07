package javaj.innerClass;

/**
 * test innerClass
 *
 * @author wangYuBai
 * @create 2018-10-03-21:54
 */
public class Demo01 {

    int outNumber;
    static int staticOutNumber;

    public void outMethod(){}
    public static void staticOutMethod(){}
    /**
     * static innerClass
     */
    private static class StaticInnerClass {
        int number;
        static String str;

        public void test() {
            number = new Demo01().outNumber;
            new Demo01().outMethod();
            staticOutMethod();
        }
    }

    /**
     * normal innerClass
     */
    private class NormalInnerClass {
        void test() {
            System.out.println(this);
        }
    }

    /**
     * part innerClass， also called method inner class
     */
    void sayHello() {
        final int a = 0;
        class LocalInnerClass {
            public void test() {
                System.out.println(a);
            }
        }
        /**
         * anonymity innerClass
         */
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
    }

    public static void main(String[] args) {
        StaticInnerClass staticInnerClass = new StaticInnerClass();
    }
}
