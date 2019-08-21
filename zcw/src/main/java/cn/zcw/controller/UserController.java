package cn.zcw.controller;

import cn.zcw.bean.AJAXResult;
import cn.zcw.bean.User;
import cn.zcw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/reg.do")
    public String doRegist(User user){
        userService.regist(user);
        return "redirect:/managers/login.html";
    }

   /* @RequestMapping("/login.do")
    public String doLogin(User user){
        int flag = userService.doLogin(user);
        if(flag==-1){
            return "/managers/login.jsp";
        }else {
        return "";
        }
    }*/

   @ResponseBody
   @RequestMapping("/login.do")
   public Object doLogin(User user){
       AJAXResult result = new AJAXResult();
       try {
           int flag = userService.doLogin(user);
           if(flag==-1){
               result.setSuccess(false);
           }else {
               result.setSuccess(true);
           }
       }catch (Exception e){
           e.printStackTrace();
           result.setSuccess(false);
       }
       return result;
   }
}
