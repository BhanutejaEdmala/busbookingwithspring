package com.example.busbookingwithspringboot.controllers;

import com.example.busbookingwithspringboot.entities.Bus;
import com.example.busbookingwithspringboot.entities.User;
import com.example.busbookingwithspringboot.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/adn")
public class BusController {
    @Autowired
    Service service;
@RequestMapping("/abus")
    public String addBus(){
    return "addbus";
}
    @RequestMapping("/regbus")
    public String registerBus(@ModelAttribute Bus bus, ModelMap m) throws ParseException {
   String r = service.addBus(bus);
   m.put("r",r);
    return "result";
    }
    @RequestMapping("/rbform")
    public String removeBusForm(){
         return "removebusform";
    }
    @RequestMapping("rembus")
    public String removeBus(@RequestParam int bno,ModelMap m){
    String s = service.removeBus(bno);
    m.put("r",s);
    return "result";
    }
    @RequestMapping("msform")
    public String modifyForm(){
    return "modifyseats";
    }
    @RequestMapping("/tbuses")
    public String availableBuses(ModelMap m){
        List<Bus> bl=service.totalBuses() ;
        m.put("bl",bl);
        return "totalbuses";
    }
    @RequestMapping("/vusers")
    public String viewUsers(ModelMap m){
    List<User> ul = service.viewUsers();
    m.put("bl",ul);
    return "totalusers";
    }
    @RequestMapping("/")
    public String home(){
    return "home";
    }
    @RequestMapping("/admin")
    public String admin(){
    return "adminhome";
    }
    @RequestMapping("/user")
    public String user(){
    return "userhome";
    }
}
