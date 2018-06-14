package com.orc.demo.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by 熊厚谨 on 2018/5/26 18:23
 *
 * @author 熊厚谨
 */
public class ImgUtil {
    public static void writeImageToDisk(byte[] img, String fileName){
        try {
            File file = new File("src\\main\\java\\com\\bst\\red_green_blue\\util\\QRcode\\img\\" + fileName+".jpg");
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
