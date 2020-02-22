package com.example.demo.controller;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Alien;
import com.example.demo.Laptop;

@RestController
public class Democontroller {

	@Autowired
	Alien alien;
	
	@Autowired
	Laptop laptop;
	
	@RequestMapping("/sample/data")
	public ArrayList<Alien> samplecontr() {
		
		ArrayList<Alien> sample = new ArrayList<Alien>();
		alien.setAid(1);
		alien.setAname("Kuppusamy lover of ramya");
		laptop.setBrand("Dont know the lap brand he current use");
		laptop.setLid(100);
		alien.setTech("RPA DEVELOPER ");
		alien.setLaptop(laptop);
		laptop.compile();
		
		sample.add(alien);
		return sample;
		
	}
	
	
}
