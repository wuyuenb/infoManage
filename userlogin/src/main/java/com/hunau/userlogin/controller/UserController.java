package com.hunau.userlogin.controller;

/**
 * @Systemname:湖南灾害应急管理系统
 * @Author:刘波
 * @Description:
 * @Date:Created in $[TIME] $[DATE]
 * @Unitname:湖南农业大学信息学院物联网工程系
 * @Copyright:综合训练系统V1.0
 * @Rewriting:刘波
 */
import com.hunau.userlogin.entity.User;
import com.hunau.userlogin.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.*;
@Controller
@RequestMapping(value = {"/user"})
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 跳转到用户登录页面
     * @return 登录页面
     */
    @RequestMapping(value = {"/loginHtml"})
    public String loginHtml(){
        return "userLogin";
    }

    /**
     * 跳转到用户注册页面
     * @return 注册页面
     */
    @RequestMapping(value = {"/registerpage"})
    public String registerpage(){
        return "register";
    }

    /**
     * 获取用户名与密码，用户登录
     * @return 登录成功页面
     */
    //@ResponseBody
    @RequestMapping(value = {"/userLogin"})
    public String userLogin(@RequestParam("name") String name,
                            @RequestParam("pwd") String pwd,
                            HttpServletRequest request){

        if(StringUtils.isEmpty(name)){
            return "用户名不能为空";
        }

        if(StringUtils.isEmpty(pwd)){
            return "密码不能为空";
        }

        User user = userService.userLogin(name,pwd);

        if(user != null){                                                  //登录成功
            request.getSession().setAttribute("session_user",user);     //将用户信息放入session  用于后续的拦截器
            return "success";
        }
        return "登录失败，用户名或密码错误";
    }

    /**
     * 注册新用户
     * @return 注册结果
     */
    //@ResponseBody
    @RequestMapping(value = {"/uregister"})
    public String addUser(@RequestParam("name") String name,@RequestParam("pwd") String pwd,@RequestParam("pwd2") String pwd2,@RequestParam("sexy") String sexy,@RequestParam("birthday")String birthday1){
        int res=0;
        if(StringUtils.isEmpty(name)){
            return "用户名不能为空";
        }

        if(StringUtils.isEmpty(pwd)){
            return "密码不能为空";
        }

        if(StringUtils.isEmpty(pwd2)){
            return "确认密码不能为空";
        }

        if(!pwd.equals(pwd2)){
            return "两次密码不相同，注册失败！！";
        }else {
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date birthday = simpleDateFormat.parse(birthday1);
                res = userService.adduser(name,pwd,sexy,birthday);
                if(res == 0){
                    return "注册失败！";
                }else {
                    return "success";
                }
            }catch(ParseException px) {
                px.printStackTrace();
                return "注册失败！";
            }
        }
        //return birthday.toString();
    }

    /**
     * 用于测试拦截器（用户是否登录，查看session）
     * 查询用户列表  http://localhost:8080/user/queryAllUser
     * @return 用户列表（json串）
     */
    //@ResponseBody
    @RequestMapping(value = {"/queryAllUser"})
    public String showUser(Model model){
        model.addAttribute("users",userService.queryAllUser());
        return "alluser";
    }

    @RequestMapping(value = {"/queryUserId"})
    public String showUserById(Model model, @RequestParam("id") Long id){
        model.addAttribute("singleuser",userService.queryUserById(id));
        return "singleuser";
    }

    @RequestMapping(value = {"/queryUserName"})
    public String showUserByName(Model model, @RequestParam("name") String name){
        model.addAttribute("muluser",userService.queryUserByName(name));
        return "muluser";
    }
    /*public List<Map<String,Object>> queryAllUser(){

        return userService.queryAllUser();
    }*/
}
