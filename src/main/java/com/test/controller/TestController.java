package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {


    //RequestMapping表示使用哪个URL来对应
    @RequestMapping({"/test","/"})
    public String test(){
        System.out.println("I Love China-------1111111111---------！");
        return "test";//test对应WEB-INF/jsp
    }

    //RequestMapping表示使用哪个URL来对应
    @RequestMapping({"/test2","/"})
    public String test2(){
        System.out.println("I Love China---------2222222------！");
        return "test";//test对应WEB-INF/jsp
    }

    //RequestMapping表示使用哪个URL来对应
    @RequestMapping({"/test3","/"})
    public String test3(@RequestParam("username") String username){
        System.out.println("I Love China！");
        System.out.println(username);
        return "test";//test对应WEB-INF/jsp
    }

    //RequestMapping表示使用哪个URL来对应
    @RequestMapping({"/test4", "/"})
    public String test4(String username, Model model) {
        System.out.println("I Love China！");
        //往前台视图传参数
        model.addAttribute("username",username);
        //context.put("username", username);
        System.out.println(username);
        return "test";//test对应WEB-INF/jsp
    }



}
