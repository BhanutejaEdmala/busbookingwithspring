package com.example.busbookingwithspringboot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.util.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno;

    private String src;
    private String dest;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Temporal(TemporalType.TIME)
    private String time;

    private int seats;

    @ElementCollection
    @CollectionTable(name = "bus_seat_numbers", joinColumns = @JoinColumn(name = "bno"))
    @Column(name = "seat_number")
    private List<String> seatNumbers = new ArrayList<>();

    @ManyToMany(cascade =  { CascadeType.PERSIST, CascadeType.MERGE },fetch = FetchType.EAGER)
    @JoinTable(
            name = "bus_passenger",
            joinColumns = @JoinColumn(name = "bno"),
            inverseJoinColumns = @JoinColumn(name = "uid")
    )
    private List<User> passengers = new ArrayList<>();
    @Override
    public String toString() {
        return "Bus{" +
                "bno=" + bno +
                ", src='" + src + '\'' +
                ", dest='" + dest + '\'' +
                ", date=" + date +
                ", time='" + time + '\'' +
                '}';
    }
}