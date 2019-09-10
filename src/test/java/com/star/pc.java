package com.star;


import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pc {
    static List<String> list = new ArrayList<>();
    static Set<String> menu_urls = new HashSet<>();
    public static void main(String[] args) {
        for (int i=1;i<8;i++){
            aa(i);
        }
        System.out.println("子链接准备完毕!");
        menu_urls.forEach(x-> System.out.println(x));
        System.out.println("开始遍历列表:");
        for (String url : menu_urls) {
            System.out.println(url);
            bb(url);
        }
        System.out.println("程序执行完毕!");
    }

    public static void aa(int page) {
        URL url = null;
        URLConnection connection = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        //String regex = "http(s?)://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?([\\.png|\\.gif]){0}";
        String regex = "http://www.qbb00.com/read/(\\d+)";
        Pattern p = Pattern.compile(regex);
        try {
            url = new URL("http://www.qbb00.com/thread/81/"+page+"&type=16");
            connection = url.openConnection();
            pw = new PrintWriter(new FileWriter("D:/b.txt"));
            br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String buff = null;
            StringBuffer st = new StringBuffer("");
            while ((buff = br.readLine()) != null) {
                st.append(new StringBuffer(buff));
            }
            Matcher matcher = p.matcher(st);
            while (matcher.find()) {
                menu_urls.add(matcher.group());
            }
            for (String uri : menu_urls) {
                pw.println(uri);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            pw.close();
        }
    }

    //https
    public static int cc(String uri) {
        int byteread = 0;
        InputStream inStream = null;
        try {
            URL url = new URL(uri);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            inStream = conn.getInputStream();
            int index = uri.lastIndexOf("/");
            String name = uri.substring(index + 1);
            //String uuid= UUID.randomUUID().toString();
            FileOutputStream fs = new FileOutputStream("D:/mypicture/" + name);
            byte[] buffer = new byte[1204 * 2];
            int flag = 0;
            while ((byteread = inStream.read(buffer)) != -1) {
                flag++;
                fs.write(buffer, 0, byteread);
            }
            if (flag == 0) {
                File file = new File("D:/mypicture/" + name);
                file.delete();
                System.out.println("文件下载失败!url:" + uri);
                return 1;
            }
            System.out.println(name + "下载成功!");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("目标文件不存在或文件已经被删除!url: " + uri);
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inStream != null)
                    inStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 1;
    }

    //http
    public static int dd(String uri) {
        int byteread = 0;
        URLConnection conn;
        InputStream inStream = null;
        try {
            URL url = new URL(uri);
            conn = url.openConnection();
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            inStream = conn.getInputStream();
            int index = uri.lastIndexOf("/");
            String name = uri.substring(index + 1);
            String uuid = UUID.randomUUID().toString();
            FileOutputStream fs = new FileOutputStream("D:/mypicture/" + name);
            byte[] buffer = new byte[1204 * 2];
            int flag = 0;
            while ((byteread = inStream.read(buffer)) != -1) {
                flag++;
                fs.write(buffer, 0, byteread);
            }
            if (flag == 0) {
                File file = new File("D:/mypicture/" + name);
                file.delete();
                System.out.print("文件下载失败!正在尝试https下载  ");
                uri = uri.substring(0, 4) + "s" + uri.substring(4, uri.length());
                cc(uri);
                return 1;
            }
            inStream.close();
            System.out.println(name + "下载成功!");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("目标文件不存在或文件已经被删除!url: " + uri);
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inStream != null)
                    inStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static void bb(String uri) {
        URL url = null;
        URLConnection connection = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        // String regex = "http(s?)://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?([\\.png|\\.gif]){0}";
        String regex = "http(s?)://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?(/*.png|gif|jpg){1}";
        Pattern p = Pattern.compile(regex);
        try {
            url = new URL(uri);
            connection = url.openConnection();
            File file = new File("D:/a.txt");
            if (file.exists()) {
                pw = new PrintWriter(new FileWriter(file, true));
            } else {
                pw = new PrintWriter(new FileWriter(file, false));
            }

            br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String buff = null;
            StringBuffer st = new StringBuffer("");
            while ((buff = br.readLine()) != null) {
                st.append(new StringBuffer(buff));
            }
            Matcher matcher = p.matcher(st);
            while (matcher.find()) {
                if (matcher.group().contains("/level/") || matcher.group().contains("logo.png")) {
                    continue;
                }
                if (list.contains(matcher.group())) {
                    continue;
                }
                list.add(matcher.group());
                pw.println(matcher.group());
                if (matcher.group().substring(0, 5).equals("https")) {
                    cc(matcher.group());
                } else {
                    dd(matcher.group());
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            pw.close();
        }
    }
}
