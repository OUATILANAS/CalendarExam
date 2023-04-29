package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.IDao;
import com.example.demo.entities.Calendar;
import com.example.demo.repositories.CalendarRepository;
@Service
public class CalendarService implements IDao<Calendar>{
	@Autowired
    private CalendarRepository calendarRepository;

	@Override
	public Calendar save(Calendar p) {
		return calendarRepository.save(p);
	}

	@Override
	public List<Calendar> findAll() {
		 return calendarRepository.findAll();
	}

	@Override
	public Calendar findById(int id) {
		return calendarRepository.findById(id);
	}

	@Override
	public Calendar update(Calendar p) {
		return calendarRepository.save(p);
	}

	@Override
	public void delete(int id) {
		calendarRepository.deleteById(id);
		
	}

	
}
