package com.hunau.userlogin.dao;

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
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface UserDao {
    /*
    @Select("select id,name,pwd,sexy,birthday,year(now())-year(birthday) as age,remark from tb_user where name like '%${value}%'")
        //@Transactional(readOnly = true)
    List<User> searchUserByName(String name);

    @Select("select id,name,pwd,sexy,birthday,year(now())-year(birthday) as age,remark from tb_user where id=#{id}")
    User searchUserByID(long id);*/
    //用户登录
    User userlogin(@Param("name") String name,@Param("pwd") String pwd);
    /**
     * 在这里写了两种新建用户的方式(具体查看sql语句)：
     *     1、id自增：即id每次加1这种
     *     2、利用UUID()生成id，在存入用户
     * 若采用第1种方式，需要对数据库中的id字段做一些修改，将id的类型改为int型，同时定义为可以自增。
     * 若采用第2种方式，则将将id的类型改为varchar型，同时取消自增。
     *
     * 无论再用那种方式，都需要注意实体类中的类型是否与数据库一致，若不一致，项目运行时报错。
     */


    //注册新用户(方式1)
    int adduser(@Param("name") String name, @Param("pwd") String pwd,@Param("sexy") String sexy, @Param("birthday") Date birthday);

    //注册新用户（方式2）
    int adduser1(@Param("name") String name, @Param("pwd") String pwd,@Param("sexy") String sexy,@Param("birthday") Date birthday);
    //更新
    int updateuser(@Param("id") long id, @Param("name") String name, @Param("pwd") String pwd,@Param("sexy") String sexy, @Param("birthday") Date birthday);
    //根据id删除用户

    List<Map<String,Object>> queryAllUser();
    //查询单个用户列表
    List<Map<String,Object>> queryUserById(@Param("id") long id);
    //根据用户名查询单个用户列表
    List<Map<String,Object>> queryUserByName(@Param("name") String name);
}
