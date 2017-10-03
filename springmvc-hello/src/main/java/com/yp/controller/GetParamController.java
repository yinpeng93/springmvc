package com.yp.controller;


import com.yp.bean.A;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * 从请求中获取参数的类
 * @author yp
 * @date 2017-10-3
 */
@Controller
public class GetParamController {
    /**
     * 从request中获取参数
     * @param request
     * @return
     */
    @RequestMapping("/hello")
    public String hello(HttpServletRequest request){
        System.out.println(request.getParameter("aaa"));
        return "hello";
    }

    /**
     * RequestParam
     * @param aaa
     * @return
     */
    @RequestMapping("/hello1")
    public String hello1(@RequestParam("aaa") String aaa){
        System.out.println("aaa = " + aaa);
        return "hello";
    }

    /**
     * javabean
     * @param a
     * @return
     */
    @RequestMapping("/hello2")
    public String hello2(A a){
        System.out.println("aaa = " + a.getAaa());
        return "hello";
    }

}
