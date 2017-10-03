package com.yp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 向页面传值
 * @author yp
 * @date 2017-10-3
 */
@Controller
public class TransferParamController {
    /**
     * 通过request传值
     * @param request
     * @return
     */
    @RequestMapping("/test1")
    public String byval(HttpServletRequest request){
        request.setAttribute("byval","test1");
        return "byval";
    }

    /**
     * 通过session传值
     * @param session
     * @return
     */
    @RequestMapping("/test2")
    public String byval1(HttpSession session){
        session.setAttribute("byval","test2");
        return "byval";
    }

    /**
     * 通过modelMap传值
     * @param modelMap
     * @return
     */
    @RequestMapping("/test3")
    public String byval2(ModelMap modelMap){
        modelMap.addAttribute("byval","test3");
        return "byval";
    }

    /**
     * 通过ModelAndView传值
     * @return
     */
    @RequestMapping("/test4")
    public ModelAndView byval3(){
        Map<String,Object> model = new HashMap<String, Object>();
        model.put("byval","test4");
        return new ModelAndView("byval",model);
    }

    /**
     * 通过Model传值
     * @param model
     * @return
     */
    @RequestMapping("/test5")
    public String byval4(Model model){
        model.addAttribute("byval","test5");
        return "byval";
    }

    /**
     * 通过map传值
     * @param map
     * @return
     */
    @RequestMapping("/test6")
    public String byval5(Map<String,Object> map){
        map.put("byval","test6");
        return "byval";
    }
}
