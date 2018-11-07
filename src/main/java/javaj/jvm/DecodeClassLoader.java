package javaj.jvm;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * decode the encode class file
 *
 * @author wangYuBai
 * @create 2018-10-03-17:53
 */
public class DecodeClassLoader extends ClassLoader {
    //defint rootDir
    private String rootDir;

    public DecodeClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> clazz = findLoadedClass(name);
        ClassLoader cl = null;

        if (null != clazz) {
            return clazz;
        } else {
            // cl = this.getParent();
            // clazz = cl.loadClass(name);

            if (null != clazz) {
                return clazz;
            } else {
                byte[] byteCode = getClassByteCode(name);

                if(null == byteCode) {
                    throw new ClassNotFoundException();
                } else {
                    clazz = defineClass(name, byteCode, 0, byteCode.length);
                }
            }
        }

        return clazz;
    }

    private byte[] getClassByteCode(String classPathName) {
        String path = rootDir + "/" + classPathName.replace(".", "/") + ".class";
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            is = new FileInputStream(path);

            int date = 0;

            while(-1 != (date = is.read())) {
                baos.write(date ^ 0xff);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != is){
                    is.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                try {
                    if (null != baos) {
                        baos.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return baos.toByteArray();
    }
}
