package com.example.busbookingwithspringboot.repositories;

import com.example.busbookingwithspringboot.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepo extends JpaRepository<Bus,Integer> {
}
