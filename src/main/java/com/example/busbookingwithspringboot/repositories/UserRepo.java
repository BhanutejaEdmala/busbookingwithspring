package com.example.busbookingwithspringboot.repositories;

import com.example.busbookingwithspringboot.entities.Bus;
import com.example.busbookingwithspringboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    @Query("SELECT u.buses FROM User u WHERE u.uid = :uid")
    List<Bus> findBusesByUid(int uid);
    boolean existsByUser(String userName);
    Optional<User> findByUser(String userName);
}
