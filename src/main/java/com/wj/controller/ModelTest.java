package com.wj.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wj on 2018/1/13.
 */
@Controller
@RequestMapping("/")
public class ModelTest {
    @Value("wj")
    private String userName;

    @ModelAttribute("sayHello")
    public String runBeforeEachHandlerCalled() {
        System.out.println("runBeforeEachHandlerCalled方法执行");
        String sayHello = "Hello " + userName;
        return sayHello;
    }

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String toHomePage() {
       return "index";
    }

    @RequestMapping(value = "/handler1")
    public String redirectMethod(@ModelAttribute("key2")String key2, RedirectAttributes attrbs) {
        System.out.println("handler1里");

        key2 = "key2value";

        attrbs.addAttribute("redirectAttr1","redirectAttr1value");
        attrbs.addFlashAttribute("redirectAttr2","redirectAttr2value");

//       return "forward:/handler2";
//       return new RedirectView("handler2");
        return "redirect:handler2";
    }

    @RequestMapping(value = "/handler2")
    public String redirectDestination(ModelMap map, String redirectAttr1,
                                      @ModelAttribute("redirectAttr2")String redirectAttr2,
                                      HttpServletRequest request, RedirectAttributes attrbs) {
        System.out.println("handler2里");
        System.out.println("ModelMap.key2值为：" + map.get("key2"));
        System.out.println("redirect.request.key2:" + request.getAttribute("key2"));
        System.out.println("redirect.request.redirectAttr1:" + request.getAttribute("redirectAttr1"));
        System.out.println("redirectAttr1值为：" + redirectAttr1);
        System.out.println("redirectAttr2值为：" + redirectAttr2);
        map.put("key3","key3value");
        attrbs.addAttribute("key4","key4value");
        return "forward:handler3";
    }

    @RequestMapping(value = "/handler3")
    public String forwardDestination(ModelMap map,@ModelAttribute("redirectAttr1") String redirectAttr1,
                                     @ModelAttribute("redirectAttr2")String redirectAttr2,@ModelAttribute("key4")String key4,
                                      HttpServletRequest request) {
        System.out.println("handler3里");
        System.out.println("ModelMap.key3值为：" + map.get("key3"));
        System.out.println("forward.request.key3:" + request.getAttribute("key3"));
        System.out.println("forward.request.redirectAttr1:" + request.getAttribute("redirectAttr1"));
        System.out.println("redirectAttr1值为：" + redirectAttr1);
        System.out.println("redirectAttr2值为：" + redirectAttr2);
        System.out.println("key4值为：" + key4);
        return "index";
    }

}
