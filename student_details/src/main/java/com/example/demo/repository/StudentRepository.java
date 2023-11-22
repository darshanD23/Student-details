package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.StudentRecord;


@Repository
public interface StudentRepository extends MongoRepository<StudentRecord, String> {

	void deleteById(long id);

}
