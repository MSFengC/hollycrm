package javaj.jvm;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

/**
 * test url classloader
 *
 * @author wangYuBai
 * @create 2018-10-02-15:54
 */
public class NetDiyClassLoader extends ClassLoader{

    private String urlRoot;

    public NetDiyClassLoader(String urlRoot) {
        this.urlRoot = urlRoot;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> clazz = findLoadedClass(name);
        ClassLoader cl = null;

        if (null != clazz) {
            return clazz;
        } else {
/*            cl = this.getParent();
            clazz = cl.loadClass(name);*/

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
        String path = urlRoot + "/" + classPathName.replace(".", "/") + ".class";
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            URL url = new URL(path);
            is = url.openStream();

            byte[] buffer = new byte[1024];
            int length = 0;

            while(-1 != (length=is.read(buffer))) {
                baos.write(buffer, 0, length);
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
