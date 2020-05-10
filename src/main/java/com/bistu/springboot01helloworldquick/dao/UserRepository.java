package com.bistu.springboot01helloworldquick.dao;

import com.bistu.springboot01helloworldquick.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

//继承JpaRepository来完成对数据库的操作
public interface UserRepository extends JpaRepository<User,Integer> {

    //public User findByUser_account(String account);
}
