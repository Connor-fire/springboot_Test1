package com.bistu.springboot01helloworldquick.entities;


import javax.persistence.*;
import java.util.Date;

@Entity//实现和数据表的映射
@Table(name = "item")//指定与哪个表对应
public class Item {

    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //自增主键
            Integer item_id;

    @Column(name = "item_name") //这是和数据表对应的列
            String item_name;

    @Column(name = "item_tel") //这是和数据表对应的列
            String item_tel;

    @Column(name = "item_price") //这是和数据表对应的列
            Integer item_price;

    @Column(name = "item_date") //这是和数据表对应的列
            Date item_date;

    @Column(name = "user_id") //这是和数据表对应的列
            Integer user_id;

    @Column(name = "buyer_id") //这是和数据表对应的列
            Integer buyer_id;

    public Integer getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(Integer buyer_id) {
        this.buyer_id = buyer_id;
    }

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_tel() {
        return item_tel;
    }

    public void setItem_tel(String item_tel) {
        this.item_tel = item_tel;
    }

    public Integer getItem_price() {
        return item_price;
    }

    public void setItem_price(Integer item_price) {
        this.item_price = item_price;
    }

    public Date getItem_date() {
        return item_date;
    }

    public void setItem_date(Date item_date) {
        this.item_date = item_date;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
