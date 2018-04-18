package com.endse.user.controller;

import com.endse.common.basic.BasicContorller;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Map<String, Object> say(String name,String say){
        System.out.println(name+":"+say);

        Map<String, Object>  msg = new HashMap<String, Object>();
        msg.put("msg","联通：我是大坑");
        return msg;
    }
}
