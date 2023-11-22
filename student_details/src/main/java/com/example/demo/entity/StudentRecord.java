package com.example.demo.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="BookingRecords")
public class StudentRecord {
	
		
		@Id
		String id;
	    
	    private String name;
	    private String age;
	    private String salary;
	    
		public StudentRecord() {
			super();
		}

		public StudentRecord(String id, String name, String age, String salary) {
			super();
			this.id = id;
			this.name = name;
			this.age = age;
			this.salary = salary;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public String getSalary() {
			return salary;
		}

		public void setSalary(String salary) {
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "StudentRecord [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
		}

}
