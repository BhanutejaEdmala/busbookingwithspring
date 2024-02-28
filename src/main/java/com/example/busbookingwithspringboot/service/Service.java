package com.example.busbookingwithspringboot.service;

import com.example.busbookingwithspringboot.entities.Bus;
import com.example.busbookingwithspringboot.entities.User;
import com.example.busbookingwithspringboot.repositories.BusRepo;
import com.example.busbookingwithspringboot.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
@org.springframework.stereotype.Service
public class Service implements  ServiceInterface {
    @Autowired
    BusRepo brepo;
    @Autowired
    UserRepo urepo;

    public String addBus(Bus b) throws ParseException {
        if (brepo.existsById(b.getBno()))
            return "Bus Already Exists";
        else {

            brepo.save(b);
            return "Bus Registered Succesfully";
        }
    }

    @Transactional
    public String bookTicket(int uid,String userName, String seatNumbers, Bus bus) {
        Optional<Bus> optionalBus = brepo.findById(bus.getBno());
        if (optionalBus.isPresent()) {
            Bus existingBus = optionalBus.get();
            // Check if the bus details match
            if (existingBus.getDate().equals(bus.getDate()) &&
                    existingBus.getTime().equals(bus.getTime()) &&
                    existingBus.getSrc().equals(bus.getSrc()) &&
                    existingBus.getDest().equals(bus.getDest())) {
                User user = new User();
                if(urepo.existsById(uid))
                    user=urepo.findById(uid).get();
                else{
                user.setUid(uid);
                user.setUser(userName);}
                List<String> seats = new ArrayList<>(Arrays.asList(seatNumbers.split(",")));
                String bos = "";
                String unbooked = "";
                for (String s : seats) {
                    if (existingBus.getSeatNumbers().contains(s))
                        bos += s + " ";
                    else
                        unbooked += s;
                }
                if (bos.length() > 0 && unbooked.length() > 0) {
                    return bos + "  are already booked\n" +
                            unbooked + " are available";
                } else if (unbooked.length() == 0)
                    return bos + "  are already booked";
                if (seats.size() > existingBus.getSeats())
                    return "Seats Are Not Sufficient";
                user.getSeats().addAll(seats);
                // Set the bus for the user
                user.getBuses().add(existingBus);

                // Add the user to the bus
                existingBus.getPassengers().add(user);

                // Update seat numbers of the bus
                existingBus.getSeatNumbers().addAll(seats);

                // Save the bus first
                existingBus.setSeats(existingBus.getSeats() - seats.size());
                brepo.save(existingBus);

                return "Bus Booked Successfully";
            } else {
                return "Bus details do not match";
            }
        } else {
            return "Bus with ID " + bus.getBno() + " does not exist";
        }
    }

    public List availableBuses(Bus b) {
        List<Bus> bl = brepo.findAll();
        List<Bus> abl = bl.stream().filter(i -> i.getSrc().equals(b.getSrc()) && i.getDest().equals(b.getDest()) && i.getDate().equals(b.getDate())).collect(Collectors.toList());
        return abl;
    }

    public String bookedSeats(int a) {
        String s = "";
        List<String> bs = brepo.findById(a).get().getSeatNumbers();
        for (String b : bs) {
            s += b + " ";
        }
        s += "Booked";
        return s;
    }

    public List viewBookings(int a ,String u) {
        List<Bus> bl = urepo.findBusesByUid(a);
        return bl;
    }
    public String ticketCancel(int bno,int uid){
        if(brepo.existsById(bno)&&urepo.existsById(uid)){
            Bus b = brepo.findById(bno).get();
          User u = urepo.findById(uid).get();
          b.getPassengers().remove(u);
          u.getBuses().remove(b);
          b.setSeats(u.getSeats().size()+b.getSeats());
          b.getSeatNumbers().removeAll(u.getSeats());
          u.getSeats().clear();
          brepo.save(b);
        return u.getUser();}
return "";
    }
    public String removeBus(int a){
        if(brepo.existsById(a)){
         Bus b = brepo.findById(a).get();
         List<User> ul = b.getPassengers();
            for(User u:ul){
                u.getSeats().clear();
            }
         ul.clear();
         b.setPassengers(ul);
         List<String> sn = b.getSeatNumbers();
       sn.clear();
       b.setSeatNumbers(sn);
         brepo.delete(b);
         return "Deleted";
        }
        else
            return "Bus Doesn't Exist";
    }
    public List totalBuses(){
      return  brepo.findAll();
    }
    public List viewUsers(){
        return urepo.findAll();
    }
}