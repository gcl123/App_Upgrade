package com.tt.javaserver.web.controller;

import com.tt.javaserver.web.service.IUserService;
import com.tt.javaserver.web.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping("/userInfo")
//    @ResponseBody
    public String userInfo(User user, HttpServletRequest request, HttpSession session) {
        System.out.println("============================");
        System.out.println("user " + user.toString());

//        request.getSession().setAttribute("hello","world");
//        request.setAttribute("nihao","nihao");

//       int result =  userService.add(user);
//        if(result != 0){
//            System.out.println("success");
//        }

//        return "index";
        return "forward:/WEB-INF/view/index.jsp";
    }


    @RequestMapping("/testJson")
    public
    @ResponseBody
    String testJson(@RequestBody User user) {
        System.out.print("Json=====" + user);
        return "user";
    }

}