package com.chanshy.SSM.controller;

import com.chanshy.SSM.domain.Item;
import com.chanshy.SSM.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private IItemService itemService;

    @RequestMapping("/save")
    public String save(Item item) throws Exception {
        itemService.save(item);
        return "redirect:/item/findAll.do";
    }


    @RequestMapping("/findAll")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Item> it = itemService.findAll();
        mv.addObject("itemList",it);
        mv.setViewName("item-list");
        return mv;
    }

    @RequestMapping("/findItem/{id}")
    public ModelAndView findItem(@PathVariable("id") Integer id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Item it = itemService.findItem(id);
//        System.out.println(it);
        mv.addObject("it", it);
        mv.setViewName("item-detail");
        return mv;
    }

    @RequestMapping(value = "/admin")
    public ModelAndView admin() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Item> it = itemService.findAll();
        mv.addObject("itemList",it);
        mv.setViewName("item-admin");
        return mv;
    }

    @RequestMapping("/alter/{id}")
    public ModelAndView alter(@PathVariable("id") Integer id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Item it = itemService.findItem(id);
        mv.addObject("it", it);
        mv.setViewName("item-alter");
        return mv;
    }

    @RequestMapping("/item-alter")
    public String alter(Item item) throws Exception {
        itemService.alter(item);
        return "redirect:/item/admin.do";
    }

    @RequestMapping(value="/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        itemService.deleteUser(id);
        return "redirect:/item/admin.do";
    }
}
