package com.example.busbookingwithspringboot.controllers;

import com.example.busbookingwithspringboot.entities.Bus;
import com.example.busbookingwithspringboot.entities.User;
import com.example.busbookingwithspringboot.service.Service;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
@Controller
@RequestMapping("/usr")
public class UserController {
    @Autowired
    Service service;
    @RequestMapping("/bookform")
    public String bookform(){
        return "bookform";
    }
    @RequestMapping("cbook")
    public String regbook(@RequestParam int uid,@RequestParam String name, @RequestParam String seatno, @ModelAttribute Bus bus, ModelMap m){
    String s = service.bookTicket(uid,name,seatno,bus);
        m.put("r",s);
     return "result";
    }
    @RequestMapping("/avabform")
    public String avaBusForm(){
        return "availablebusform";
    }
    @RequestMapping("/avabus")
    public String avabuses(@ModelAttribute Bus bus,ModelMap m){
  List<Bus> abl = service.availableBuses(bus);
      m.put("abl",abl);
  return "availablebuses";
    }
@RequestMapping("/bseats")
    public String bookedSeats(@RequestParam int bno,ModelMap m){
        String s = service.bookedSeats(bno);
        m.put("r",s);
        return "result";
}
@RequestMapping("/vbform")
    public String viewBookFrom(){
        return "viewbookform";
}
@RequestMapping("/vbook")
    public String viewBookings(@RequestParam int uid,@RequestParam String user,ModelMap m){
        List<Bus> bl =  service.viewBookings(uid,user);
        m.put("bl",bl);
        m.put("uid",uid);
        return "bookings";
}
@RequestMapping("/cacl")
    public String ticketCancel(@RequestParam int bno,@RequestParam int uid){
      String s = service.ticketCancel(bno,uid);
    return "redirect:/usr/vbook?bno=" + bno + "&uid=" + uid+"&user="+s;
}
}
