package com.example.busbookingwithspringboot;

import com.example.busbookingwithspringboot.entities.Bus;
import com.example.busbookingwithspringboot.entities.User;
import com.example.busbookingwithspringboot.repositories.BusRepo;
import com.example.busbookingwithspringboot.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BusbookingwithspringbootApplication implements CommandLineRunner {
	@Autowired
	BusRepo brepo;
	@Autowired
	UserRepo urepo;

	public static void main(String[] args) {
		SpringApplication.run(BusbookingwithspringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Bus> v = urepo.findBusesByUid(1);
		System.out.println(v);
	}
}