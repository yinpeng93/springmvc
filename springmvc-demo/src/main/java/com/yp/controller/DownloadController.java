package com.yp.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 测试文件下载
 */
@Controller
public class DownloadController {
    /**
     * 1.利用ResponseEntity做文件下载
     * @return
     * @throws IOException
     */
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download() throws IOException{
        File file = new File("d:\\springmvc基础知识-xxw.pptx");
        byte[] body = null;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition","attachment;filename=" +
                new String(file.getName().getBytes("utf-8"),"iso8859-1"));//解决中文文件名乱码
        HttpStatus status = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body,headers,status);
        return  entity;
    }

    @RequestMapping("/download1")
    public void downloadCommon(HttpServletResponse response){
        String filePath = "d:\\springmvc基础知识-xxw.pptx";
        String newFileName = "springmvc基础知识.pptx";
        download1(newFileName,filePath,response);
    }

    /**
     * 2.java通用下载实现
     */
    public static void download1(String fileName, String filePath,
                                 HttpServletResponse response){
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            //设置响应头和客户端保存文件名
            response.setHeader("Content-Disposition","attachment;fileName="+
                    new String(fileName.getBytes("utf-8"),"iso8859-1"));
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            //打开本地文件流
            inputStream = new FileInputStream(filePath);
            //激活下载操作
            outputStream = response.getOutputStream();
            //循环写入输出流
            byte[] bytes = new byte[2048];
            int length;
            while ((length=inputStream.read(bytes))>0){
                outputStream.write(bytes,0,length);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
