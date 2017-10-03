package com.yp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * 测试重定向
 * @author yp
 * @date 2017-10-3
 */
@Controller
public class RedirectController {

    /**
     * string
     * @return
     */
    @RequestMapping("/tohello")
    public String redir(){
        return "redirect:/demo/hello";
    }

    /**
     * ModelAndView
     * @return
     */
    @RequestMapping("/tohello2")
    public ModelAndView redir2(){
        RedirectView rv = new RedirectView("/demo/hello");
        return new ModelAndView(rv);
    }
}
