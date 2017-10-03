package com.yp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试json返回
 */
@Controller
public class JsonController {
    @RequestMapping("/json")
    @ResponseBody
    public String json(){
        return "this is json";
    }
}
