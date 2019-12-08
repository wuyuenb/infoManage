package com.hunau.userlogin.service;

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
import com.hunau.userlogin.dao.UserDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    //用户登录
    public User userLogin(String name,String pwd){
        return userDao.userlogin(name,pwd);
    }

    //注册新用户
    public int adduser(String name, String pwd, String sexy, Date birthday){

        /**
         * 注意查看mapper中的注释
         */

        //return usermapper.adduser(username,password,age);
        return userDao.adduser1(name,pwd,sexy,birthday);     //对应sql语句中的第二种注册方式
    }

    //查询用户列表
    public List<Map<String,Object>> queryAllUser(){
        return userDao.queryAllUser();
    }

    //根据id查询用户列表
    public List<Map<String,Object>> queryUserById(long id){
        return userDao.queryUserById(id);
    }

    //根据name模糊查询用户列表
    public List<Map<String,Object>> queryUserByName(String name){
        return userDao.queryUserByName(name);
    }


}
