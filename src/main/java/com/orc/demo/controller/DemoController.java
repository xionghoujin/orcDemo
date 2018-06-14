package com.orc.demo.controller;

import com.orc.demo.common.Constant;
import com.orc.demo.common.ServerResponse;
import com.orc.demo.util.AipOcr;
import com.orc.demo.util.ImgIoUtil;
import com.orc.demo.util.OcrUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by 熊厚谨 on 2018/5/26 22:43
 *
 * @author 熊厚谨
 */
@RestController
@RequestMapping("/Demo")
public class DemoController {

    @ApiOperation(value = "阿里云")
    @PostMapping(value = "ocrA")
    public ServerResponse<String> ocrAliApi(@RequestBody MultipartFile file) {
        if (file == null) {
            return ServerResponse.createByErrorMessage("上传失败");
        }
        String s1 = null;
        try {
            System.out.println(Constant.i);
            String s = ImgIoUtil.Base64Convert(file.getBytes());
            s1 = OcrUtil.ImageConversionText(s);
            System.out.println(s1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ServerResponse.createBySuccess(s1);
    }

    @ApiOperation(value = "百度云")
    @PostMapping(value = "ocrB")
    public ServerResponse ocrBaiduApi( MultipartFile file) {
        if (file == null) {
            return ServerResponse.createByErrorMessage("上传失败");
        }
        byte[] bytes = null;
        String ocrinvoking;
        long after ;

        try {
            bytes = file.getBytes();
        }catch (IOException e) {
            e.printStackTrace();
        }
            after = System.currentTimeMillis();
            ocrinvoking = AipOcr.ocrinvoking(bytes);
        if (ocrinvoking != null) {
            System.out.println("时间"+(System.currentTimeMillis() - after));
            System.out.println(ocrinvoking);

            return ServerResponse.createBySuccess(ocrinvoking);
        }
        System.out.println("识别失败");
        return ServerResponse.createByErrorMessage("识别失败");


    }
}
