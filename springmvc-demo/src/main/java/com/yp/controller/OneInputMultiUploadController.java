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
import java.util.List;

/**
 * 单个input上传多个文件
 * @author yp
 * @date 2017-10-4
 */
@Controller
public class OneInputMultiUploadController {
    @RequestMapping("/tomultiupload1")
    public String toUpload(){
        return "multiUpload1";
    }

    @RequestMapping(value = "/doMultiUpload1",method = RequestMethod.POST)
    public String doUploadFile(MultipartHttpServletRequest request){
        Iterator<String> fileNames = request.getFileNames();
        while (fileNames.hasNext()){
            String fileName = fileNames.next();
            List<MultipartFile> files = request.getFiles(fileName);
            if(!files.isEmpty()){
                for (MultipartFile file : files) {
                    try {
                        FileUtils.copyInputStreamToFile(file.getInputStream(),new File("d:\\temp\\multifile\\",
                                System.currentTimeMillis()+file.getOriginalFilename()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "success";
    }
}
