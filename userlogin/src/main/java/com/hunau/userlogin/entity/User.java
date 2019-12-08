package com.hunau.userlogin.entity;

/**
 * @Systemname:湖南灾害应急管理系统
 * @Author:刘波
 * @Description:
 * @Date:Created in $[TIME] $[DATE]
 * @Unitname:湖南农业大学信息学院物联网工程系
 * @Copyright:综合训练系统V1.0
 * @Rewriting:刘波
 */
import javax.persistence.*;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.Date;
import java.util.List;
@Entity
@Table(name="tb_user")
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Column(length=40)
    private String name;
    @Column(length=50)
    private String pwd;
    @Column(length = 4)
    private String sexy;
    private Date birthday;
    private int age;
    private boolean remark;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd==null?null:pwd.trim();
    }

    public String getSexy() {
        return sexy;
    }

    public void setSexy(String sexy) {
        this.sexy = sexy;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isRemark() {
        return remark;
    }

    public void setRemark(boolean remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        LocalDateTime dt = LocalDateTime.now();
        return "User{" +
                "编号=" + id +
                ", 姓名='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sexy='" + sexy + '\'' +
                ", birthday=" +String.format("%tF",birthday) +
                ",age="+ age+
                // ",age="+ (dt.getYear())+
                ", remark=" + remark +
                '}';
    }
}
