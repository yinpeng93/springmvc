package com.yp.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 测试文件上传
 * @author yp
 * @date 2017-10-3
 */
@Controller
public class UploadController {
    @RequestMapping("/toupload")
    public String toUpload(){
        return "upload";
    }

    @RequestMapping(value = "/doUpload",method = RequestMethod.POST)
    public String doUploadFile(@RequestParam("file") MultipartFile file){
        if(!file.isEmpty()){
            try {
                //这里将上传得到的文件保存至d:\\temp\\file 目录
                FileUtils.copyInputStreamToFile(file.getInputStream(),new File("d:\\temp\\file\\",
                        System.currentTimeMillis()+file.getOriginalFilename()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "success";
    }
}
