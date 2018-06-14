package com.orc.demo.util;





import com.google.gson.Gson;
import com.orc.demo.pojo.Body;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 熊厚谨 on 2018/5/26 19:30
 *
 * @author 熊厚谨
 */
public class OcrUtil {
    public static String ImageConversionText(String s) {
        String s1 = null;
        String host = "https://tysbgpu.market.alicloudapi.com";
        String path = "/api/predict/ocr_general";
        String method = "POST";
        String appcode = "22e90d229d5a45ccbec9b1910b8901b6";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/json; charset=UTF-8");
//        headers.put("Connection", "close");
        Map<String, String> querys = new HashMap<String, String>();
        String bodys = "{\"image\":\""+s+"\",\"configure\":\"{\\\"min_size\\\":16,\\\"output_prob\\\":true}\"}";


        try {

            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            s1 = EntityUtils.toString(response.getEntity());
            System.out.println(s1);
            Gson gson = new Gson();
            Body body = gson.fromJson(s1, Body.class);
            return body.getRet().get(0).getWord();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s1;
    }
}
