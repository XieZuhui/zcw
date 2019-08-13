package cn.zcw.controller;

import cn.zcw.bean.User;
import cn.zcw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/reg.do")
    public String doRegist(User user){
        userService.regist(user);
        return "/index";
    }

    @RequestMapping("/login.do")
    public String doLogin(User user){
        int flag = userService.doLogin(user);
        if(flag==-1){
            return "/login";
        }else {
        return "//index";
        }
    }
}
