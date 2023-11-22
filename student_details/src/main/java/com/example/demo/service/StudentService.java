package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentRecord;
import com.example.demo.repository.StudentRepository;


@Service
public class StudentService {
	
	
		@Autowired
		private StudentRepository studentrepository;

		public StudentRecord save(StudentRecord records) {
			return studentrepository.save(records);
		}
		
		public List<StudentRecord> findAll() {
			return studentrepository.findAll();
		}

		public void delete(long id) {
			studentrepository.deleteById(id);
		}

		public Object getRecordById(String id) {
			return studentrepository.findById(id);
		} 

}
