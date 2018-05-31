package com.sooying.pay.third.api.util;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * ClassName: HttpKit
 */
public class HttpKit {
    
    private static final String DEFAULT_CHARSET = "UTF-8";
    /**
     * 
    * @Title: get 
    * @Description: get请求
    * @param @param url
    * @param @return     
    * @return String     
     */
    public static String get(String url) {
        StringBuffer bufferRes = null;
        try {
            URL urlGet = new URL(url);
            HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
            // 连接超时
            http.setConnectTimeout(25000);
            // 读取超时 --服务器响应比较慢，增大时间
            http.setReadTimeout(25000);
            http.setRequestMethod("GET");
            http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
            http.connect();
            
            InputStream in = http.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(in, DEFAULT_CHARSET));
            String valueString = null;
            bufferRes = new StringBuffer();
            while ((valueString = read.readLine()) != null){
                bufferRes.append(valueString);
            }
            in.close();
            if (http != null) {
                // 关闭连接
                http.disconnect();
            }
            return bufferRes.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * 
    * @Title: post 
    * @Description: post请求 
    * @param @param url
    * @param @param params
    * @return String     
     */
    public static String post(String url, String params) {
        StringBuffer bufferRes = null;
        try {
            URL urlPost = new URL(url);
            HttpURLConnection http = (HttpURLConnection) urlPost.openConnection();
            // 连接超时
            http.setConnectTimeout(10000);
            // 读取超时 --服务器响应比较慢，增大时间
            http.setReadTimeout(10000);
            http.setRequestMethod("POST");
            http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            // 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在   
            // http正文内，因此需要设为true, 默认情况下是false; 
            http.setDoOutput(true);
            // 设置是否从httpUrlConnection读入，默认情况下是true; 
            http.setDoInput(true);
            // Post 请求不能使用缓存   
            http.setUseCaches(false);
            http.connect();
            // 现在通过输出流对象构建对象输出流对象，以实现输出可序列化的对象
            OutputStream out = http.getOutputStream();
            out.write(params.getBytes("UTF-8"));
            // 刷新对象输出流，将任何字节都写入潜在的流中（些处为ObjectOutputStream）
            out.flush();
            // 关闭流对象。此时，不能再向对象输出流写入任何数据，先前写入的数据存在于内存缓冲区中
            // 在调用下边的getInputStream()函数时才把准备好的http请求正式发送到服务器
            out.close();
            // 调用HttpURLConnection连接对象的getInputStream()函数,   
            // 将内存缓冲区中封装好的完整的HTTP请求电文发送到服务端
            InputStream in = http.getInputStream();// <===注意，实际发送请求的代码段就在这里   

            BufferedReader read = new BufferedReader(new InputStreamReader(in, DEFAULT_CHARSET));
            String valueString = null;
            bufferRes = new StringBuffer();
            while ((valueString = read.readLine()) != null){
                bufferRes.append(valueString);
            }
            in.close();
            if (http != null) {
                // 关闭连接
                http.disconnect();
            }
            return bufferRes.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
