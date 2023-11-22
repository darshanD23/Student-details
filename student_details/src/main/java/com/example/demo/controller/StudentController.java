package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.StudentRecord;
import com.example.demo.service.StudentService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("student")
public class StudentController {
	@Autowired
	private StudentService studentservice;
	
	@PostMapping("/")
	public StudentRecord addRecords(@RequestBody StudentRecord records) {
		return this.studentservice.save(records);
	}

	@PutMapping("/{id}")
	public StudentRecord updateRecords(@RequestBody StudentRecord records) {
		return this.studentservice.save(records);
	}

	@DeleteMapping("/{id}")
	public void deleteRecords(@PathVariable("id") long id) {
		this.studentservice.delete(id);
	}
	

	@GetMapping("/")
	public List<StudentRecord> getRecords() {
		return this.studentservice.findAll();
	}

}
