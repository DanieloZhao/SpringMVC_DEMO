package com.test.controller;



import com.test.jdbc.MySqlUtils;
import com.test.model.User;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping(value="/user")
public class UserController {

    private static List<User> userList;

    public UserController()
    {
        this.userList = new ArrayList<User>();
    }

    @RequestMapping(value="/register",method = RequestMethod.GET)
    public String registerForm()
    {
        return "/user/registerForm";//跳转到registerForm.jsp注册页面
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)

    public String register( String loginname,
                            String username,
                            String password)
    {
        User user = new User();
        user.setLoginname(loginname);
        user.setUsername(username);
        user.setPassword(password);

        String haha = "哈哈";

        System.out.println("----------username---->"+username+"---haha--->"+haha);

        MySqlUtils.Instance().insertAUser(user);

        return "/user/loginForm";//跳转到登录页面
    }

    @RequestMapping(value = "login")
    public String login(@RequestParam("loginname") String loginname,
                        @RequestParam("password") String password,
                        Model model)
    {


        User user = MySqlUtils.Instance().queryLoginnameAndPassword(loginname,password);
            if(user!=null)
            {
                model.addAttribute("user",user);
                return "/user/welcome";
            }

        return "user/loginForm";
    }
    @RequestMapping(value = "loginForm")
    public String loginForm()
    {
        return "user/loginForm";
    }





    @RequestMapping(value = "/param2")
    public void param2(HttpServletRequest request, HttpServletResponse response)
    {
        try {
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print( map2JsonStr());
            out.flush();
            out.close();
        } catch (Exception var3) {
            var3.printStackTrace();
        }


    }

    private String map2JsonStr()
    {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("status",0);
        map.put("msg",123);
        //net.sf.json.JSONObject 将Map转换为JSON方法
   JSONObject js = JSONObject.fromObject(map);


        return js.toString();
    }



}
