package javaj.jvm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * encode class file
 *
 * @author wangYuBai
 * @create 2018-10-03-17:32
 */
public class Encode {

    public static void main(String[] args) {
        File src = new File("F:\\Demo02\\javaj\\javassist\\Emp.class");
        File dest = new File("F:\\Demo02\\javaj\\javassist\\Emp.class");

        encode(src, dest);
    }

    public static void encode(File src, File dest) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);
            int date = 0;

            while(-1 != (date = fis.read())) {
                fos.write(date ^ 0xff);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if(null != fos) {
                    fos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if(null != fis) {
                        fis.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
