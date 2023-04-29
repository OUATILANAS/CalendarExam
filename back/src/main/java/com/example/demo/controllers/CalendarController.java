package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Calendar;
import com.example.demo.services.CalendarService;

@RestController
@RequestMapping("api/calendars")
public class CalendarController {

	@Autowired
	CalendarService calendarService;

	
	@PostMapping("/save")
	public Calendar save(@RequestBody Calendar p) {
		return calendarService.save(p);
	}

	@GetMapping("/all")
	public List<Calendar> findAll() {
		return calendarService.findAll();
	}

	@GetMapping("/id/{id}")
	public Calendar findById(@PathVariable int id) {
		return calendarService.findById(id);
	}

	@PutMapping("/update")
	public Calendar update(@RequestBody Calendar p) {
		return calendarService.update(p);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		calendarService.delete(id);
	}
	
	
}
