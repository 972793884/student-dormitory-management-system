package com.star;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class test {
    public static InputStream inStream = null;
    public static void main(String[] args){
        try {
            //要访问的图片链接
            URL url = new URL("https://s6tu.com/images/2018/07/08/SNIS-333-4.gif");
            //建立网络连接
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            //inStream = con.getInputStream();
            //中转站，现将图片数据放到outStream中
            //ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(con
                    .getInputStream(),"UTF-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
           /* byte[] buf = new byte[1024];
            int len = 0;
            while((len = inStream.read(buf)) != -1){
                outStream.write(buf,0,len);
            }
            inStream.close();
            outStream.close();
            File file = new File("D://a.jpg"); //图片下载的位置
            FileOutputStream op = new FileOutputStream(file);
            op.write(outStream.toByteArray());
            op.close();*/
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
