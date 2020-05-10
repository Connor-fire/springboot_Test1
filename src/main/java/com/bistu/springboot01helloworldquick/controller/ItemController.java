package com.bistu.springboot01helloworldquick.controller;

import com.bistu.springboot01helloworldquick.dao.ItemRepository;
import com.bistu.springboot01helloworldquick.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Controller
public class ItemController {



    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/main.html")
    public String buy(Model model,
                      HttpSession session) {
//        Collection<Employee> items = itemDao.getAll();
        System.out.println("userId是:"+session.getAttribute("userId"));
        List<Item> items2=itemRepository.findItemByUser_id((Integer) session.getAttribute("userId"));
        List<Item> items3=itemRepository.findItemByBuyer_id((Integer) session.getAttribute("userId"));
        model.addAttribute("items",items3);
        return "dashboard";
    }


    @GetMapping("/buy/{id}")
    public String buyItem(@PathVariable("id") Integer id,Model model,HttpSession session){
        Item item=null;
        Optional<Item> opt =itemRepository.findById(id);
        if(opt.isPresent()){
            item=opt.get();
        }
        item.setBuyer_id((Integer) session.getAttribute("userId"));
        itemRepository.save(item);
        return "redirect:/items";//redirect重定向
    }


    @GetMapping("/items")
    public String list(Model model) {

        List<Item> items=itemRepository.findItemByBuyer_id(0);

        System.out.println("items:");
        for(int i=0;i<items.size();i++){
            System.out.println(items.get(i).getItem_id()+" "+items.get(i).getBuyer_id());
        }

        model.addAttribute("items",items);
        return "item/list";
    }

    @GetMapping("/item")
    public String toAddPage(Model model){

        return "item/add";
    }



    @PostMapping("/item")
    public String addItem(Item item,@RequestParam("itemId") Integer itemId,
                          @RequestParam("name") String name,
                          @RequestParam("tel") String tel,
                          @RequestParam("price") Integer price,
                          @RequestParam("date") Date date,
                          @RequestParam("userId") Integer userId){

        System.out.print("商品ID:"+item.getItem_id()+"\n");
        System.out.print("商品ID:"+itemId+"\n");
        System.out.print("商品name:"+name+"\n");
        System.out.print("商品tel:"+tel+"\n");
        System.out.print("商品price:"+price+"\n");
        System.out.print("商品date:"+date+"\n");
        System.out.print("商品userId:"+userId+"\n");
        item.setItem_id(itemId);
        item.setItem_name(name);
        item.setItem_tel(tel);
        item.setItem_price(price);
        item.setItem_date(date);
        item.setUser_id(userId);
        item.setBuyer_id(0);
        itemRepository.save(item);
        return "redirect:/items";//redirect重定向
    }

    @GetMapping("/item/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){


        Item item=null;
        Optional<Item> opt =itemRepository.findById(id);
        if(opt.isPresent()){
            item=opt.get();
        }
        model.addAttribute("item",item);

        return "item/add";
    }

    @PutMapping("/item")///{itemId}/{name}/{tel}/{price}/{date}/{userId}
    public  String updateItem(Item item, @RequestParam("itemId") Integer itemId,
                              @RequestParam("name") String name,
                              @RequestParam("tel") String tel,
                              @RequestParam("price") Integer price,
                              @RequestParam("date") Date date,
                              @RequestParam("userId") Integer userId){
        System.out.print("商品ID:"+item.getItem_id()+"\n");
        System.out.print("商品ID:"+itemId+"\n");
        System.out.print("商品name:"+name+"\n");
        System.out.print("商品tel:"+tel+"\n");
        System.out.print("商品price:"+price+"\n");
        System.out.print("商品date:"+date+"\n");
        System.out.print("商品userId:"+userId+"\n");
        item.setItem_id(itemId);
        item.setItem_name(name);
        item.setItem_tel(tel);
        item.setItem_price(price);
        item.setItem_date(date);
        item.setUser_id(userId);
        item.setBuyer_id(0);
        itemRepository.save(item);

        return "redirect:/items";//redirect重定向
    }

    @DeleteMapping("/item/{id}")
    public String deleteItem(@PathVariable("id") Integer id){
        System.out.print("商品ID:"+id+"\n");
        itemRepository.deleteById(id);
        return "redirect:/items";//redirect重定向
    }
}
