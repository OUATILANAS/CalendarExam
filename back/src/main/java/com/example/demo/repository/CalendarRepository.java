package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Calendar;


public interface CalendarRepository extends JpaRepository<Calendar, Integer>{
	
	Calendar findById(int id);

	
}
