package com.example.busbookingwithspringboot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.service.spi.InjectService;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;

    private String user;

    @ElementCollection
    @CollectionTable(name = "user_seats", joinColumns = @JoinColumn(name = "uid"))
    @Column(name = "seat")
    private List<String> seats = new ArrayList<>();
    @ManyToMany(mappedBy = "passengers",cascade =  { CascadeType.PERSIST, CascadeType.MERGE },fetch = FetchType.EAGER)
    private List<Bus> buses = new ArrayList<>();
    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", user='" + user + '\'' +
                '}';
    }
}
