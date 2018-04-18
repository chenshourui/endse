package com.endse.user.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/18.
 */
@Scope("prototype")
@Controller
@RequestMapping("/userController")
public class UserController {

    @ResponseBody
    @RequestMapping("say")
    public Map<String, Object> say(HttpServletRequest arg0, HttpServletResponse arg1){
        System.out.println("SB LT");

        Map<String, Object>  msg = new HashMap<String, Object>();
        msg.put("msg","曹尼玛的联通");
        return msg;
    }
}
