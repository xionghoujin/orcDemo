package com.orc.demo.util;

import com.baidu.aip.client.BaseClient;
import com.baidu.aip.http.AipRequest;
import com.google.gson.Gson;
import com.orc.demo.common.OcrConsts;
import com.baidu.aip.util.Base64Util;
import com.orc.demo.pojo.OrcBean;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by 熊厚谨 on 2018/5/26 23:14
 *
 * @author 熊厚谨
 */
public class AipOcr extends BaseClient{
    public AipOcr(String appId, String apiKey, String secretKey) {
        super(appId, apiKey, secretKey);
    }

    /**
     * 通用文字识别接口
     * 用户向服务请求识别某张图中的所有文字
     *
     * @param image - 二进制图像数据
     * @param options - 可选参数对象，key: value都为string类型
     * options - options列表:
     *   language_type 识别语言类型，默认为CHN_ENG。可选值包括：<br>- CHN_ENG：中英文混合；<br>- ENG：英文；<br>- POR：葡萄牙语；<br>- FRE：法语；<br>- GER：德语；<br>- ITA：意大利语；<br>- SPA：西班牙语；<br>- RUS：俄语；<br>- JAP：日语；<br>- KOR：韩语；
     *   detect_direction 是否检测图像朝向，默认不检测，即：false。朝向是指输入图像是正常方向、逆时针旋转90/180/270度。可选值包括:<br>- true：检测朝向；<br>- false：不检测朝向。
     *   detect_language 是否检测语言，默认不检测。当前支持（中文、英语、日语、韩语）
     *   probability 是否返回识别结果中每一行的置信度
     * @return JSONObject
     */
    public JSONObject basicGeneral(byte[] image, HashMap<String, String> options) {
        AipRequest request = new AipRequest();
        preOperation(request);

        String base64Content = Base64Util.encode(image);
        request.addBody("image", base64Content);
        if (options != null) {
            request.addBody(options);
        }
        request.setUri(OcrConsts.GENERAL_BASIC);
        postOperation(request);
        return requestServer(request);
    }

    public static String ocrinvoking(byte[] image) {
        AipOcr ocr = new AipOcr("11303854","tlyeLfXDawkiQWQHolkbPLAH","1gk8q9y4my8KmydrzfPp6piEawuGfK67");
        JSONObject jsonObject = ocr.basicGeneral(image, null);
        System.out.println(jsonObject);
        Gson gson = new Gson();
        OrcBean orcBean = gson.fromJson(jsonObject.toString(), OrcBean.class);

        if (orcBean.getWords_result().size() == 0) {
            return null;
        }
        return orcBean.getWords_result().get(0).getWords();

    }
}
