package com.bistu.springboot01helloworldquick.entities;

import javax.persistence.*;

@Entity//实现和数据表的映射
@Table(name = "user")//指定与哪个表对应
public class User {

    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //自增主键
            Integer user_id;

    @Column(name = "user_account") //这是和数据表对应的列
            String user_account;

    @Column(name = "user_password")
    String user_password;

    @Column(name = "user_limits")
    Integer user_limits;

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Integer getUser_limits() {
        return user_limits;
    }

    public void setUser_limits(Integer user_limits) {
        this.user_limits = user_limits;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}

