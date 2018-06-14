package com.orc.demo.util;

import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by 熊厚谨 on 2018/5/25 17:54
 *
 * @author 熊厚谨
 */
public class ImgIoUtil {
    public static String Base64Convert(byte[] img) {
        //          将byte数组转换为base64
        String encode = new BASE64Encoder().encode(img);
        return encode;

    }


    /**
     * 获取http地址上的图片资源，并转码为base64
     * @param url
     * @return
     */
    public static String getBitmap(String url) {
        URL imageURL = null;
        byte[] bytes = null;
        String s = null;
        try {
            imageURL = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            HttpURLConnection conn = (HttpURLConnection) (imageURL != null ? imageURL
                    .openConnection() : null);
            conn.setDoInput(true);
            conn.connect();
            InputStream is = conn.getInputStream();

            bytes = readInputStream(is);
//          将byte数组转换为base64
            s = new BASE64Encoder().encode(bytes);
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src\\readImg\\1.txt")));
            stream.write(s.getBytes());
            stream.close();
            is.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * 将输入流中的信息转换为字节数组
     * @param inStream
     * @return
     * @throws Exception
     */
    public static byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while( (len=inStream.read(buffer)) != -1 ){
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }

    /**
     * 将图片的字节流写出到目标地址
     * @param img
     * @param fileName
     */
    public static void writeImageToDisk(byte[] img, String fileName){
        try {
            File file = new File("src\\readImg\\" + fileName+".jpeg");
            FileOutputStream fops = new FileOutputStream(file);
            BufferedOutputStream bfs = new BufferedOutputStream(fops);
            bfs.write(img);
            bfs.flush();
            bfs.close();
            System.out.println("图片已经写入到C盘");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
