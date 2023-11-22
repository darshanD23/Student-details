package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.StudentRecord;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;




@RunWith(SpringRunner.class)
@SpringBootTest
class StudentDetailsApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private StudentService studentservice;
	
	@MockBean
	private StudentRepository studentrepository;
	
	@Test
	public void getStudentTest() {
		when(studentrepository.findAll()).thenReturn(Stream.
				of(new StudentRecord("1","Puni","24","10000")).collect(Collectors.toList()));
		assertEquals(1, studentservice.findAll().size());
	}
	
	@Test
	public void getAllStudentTest() {
		List<StudentRecord> list = new ArrayList<StudentRecord>();
		StudentRecord records1=new StudentRecord("1","Puni","24","10000");
		StudentRecord records2=new StudentRecord("2","suni","25","20000");
		StudentRecord records3=new StudentRecord("3","ani","26","30000");
		
		list.add(records1);
		list.add(records2);
		list.add(records3);
		
		when(studentrepository.findAll()).thenReturn(list);
		
		//test
		List<StudentRecord> StudentList=studentservice.findAll();
		assertEquals(3, StudentList.size());
		verify(studentrepository, times(1)).findAll();
	}
	
//	test for save Booking
	@Test
	public void saveTest() {
		StudentRecord records=new StudentRecord("1","Puni","24","10000");
		when(studentrepository.save(records)).thenReturn(records);
		assertEquals(records, studentservice.save(records));
	}
	
//	test for delete student
	@Test
	public void deleteTest() {
		long id=101;
		StudentRecord records=new StudentRecord("1","Puni","24","10000");
		studentservice.delete(id);
		verify(studentrepository,times(1)).deleteById(id);
	}

}
