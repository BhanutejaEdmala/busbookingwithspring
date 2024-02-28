package com.example.busbookingwithspringboot.service;

import com.example.busbookingwithspringboot.entities.Bus;

import java.text.ParseException;
import java.util.List;

public interface ServiceInterface {
    public String addBus(Bus b) throws ParseException;
    public String bookTicket(int uid,String userName, String seatNumbers, Bus bus);
    public List availableBuses(Bus b);
    public String bookedSeats(int a);
    public List viewBookings(int a ,String u);
    public String ticketCancel(int bno,int uid);
    public String removeBus(int a);
    public List totalBuses();
    public List viewUsers();
}
