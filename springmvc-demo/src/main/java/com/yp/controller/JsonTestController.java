package com.yp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Springmvc 4以上版本增加了@RestController标签相当于所有返回都增加了@ResponseBody
 * @author yp
 * @date 2017-10-3
 */
@RestController
public class JsonTestController {
    @RequestMapping("/json1")
    public String json1(){
        return "this is json";
    }

    @RequestMapping("/json2")
    public Map<String,Object> json2(){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("hello","nihao");
        map.put("what's your name","yp");
        return map;
    }
}
