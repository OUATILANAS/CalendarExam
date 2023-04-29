package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Calendar;


public interface CalendarRepository extends JpaRepository<Calendar, Integer>{
	
	Calendar findById(int id);

	
}
