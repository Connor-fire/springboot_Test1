package com.bistu.springboot01helloworldquick.dao;

import com.bistu.springboot01helloworldquick.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Integer> {

    @Query(name = "findItemByItem_id",nativeQuery = true,value =
            "select * from item where item_id = :id")
    List<Item> findItemByItem_id(@Param("id")Integer id);

    @Query(name = "findItemByUser_id",nativeQuery = true,value =
            "select * from item where user_id = :id")
    List<Item> findItemByUser_id(@Param("id")Integer id);

    @Query(name = "findItemByBuyer_id",nativeQuery = true,value =
            "select * from item where buyer_id = :id")
    List<Item> findItemByBuyer_id(@Param("id")Integer id);
}
