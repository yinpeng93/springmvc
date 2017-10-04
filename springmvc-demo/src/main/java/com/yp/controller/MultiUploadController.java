package com.yp.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * 多文件上传
 * @author yp
 * @date 2017-10-4
 */
@Controller
public class MultiUploadController {
    @RequestMapping("/tomultiupload")
    public String toMultiUpload(){
        return "multiUpload";
    }

    @RequestMapping(value = "/doMultiUpload",method = RequestMethod.POST)
    public String doUploadFile(MultipartHttpServletRequest request){
        Iterator<String> fileNames = request.getFileNames(); //获得所有的文件名
        System.out.println("fileNames = " + fileNames);
        while (fileNames.hasNext()){ //迭代对单个文件进行操作
            String fileName = fileNames.next();
            MultipartFile file = request.getFile(fileName);
            if(!file.isEmpty()){
                try {
                    FileUtils.copyInputStreamToFile(file.getInputStream(),new File("d:\\temp\\multifile\\",
                            System.currentTimeMillis()+file.getOriginalFilename()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "success";
    }
}
