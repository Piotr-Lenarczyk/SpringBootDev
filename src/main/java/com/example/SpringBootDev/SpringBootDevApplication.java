package com.example.SpringBootDev;

import com.example.SpringBootDev.dao.StudentDAO;
import com.example.SpringBootDev.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringBootDevApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDevApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);
			// createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteStudents(studentDAO);
		};
	}

	private void deleteStudents(StudentDAO studentDAO) {
		System.out.format("Deleting all students, %d rows affected", studentDAO.deleteAll());
	}

	private void deleteStudent(StudentDAO studentDAO) {
		System.out.println("Deleting student");
		studentDAO.delete(1);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int id = 1;
		Student student = studentDAO.findById(id);
		student.setFirstName("Jonathan");
		studentDAO.update(student);
		System.out.println(student);
	}

	private void queryByLastName(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findByLastName("Parks");
		for (Student student : studentList) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findAll();
		for (Student student : studentList) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println(studentDAO.findById(1));
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 new Student objects");
		Student student1 = new Student("Lucille", "Davis", "lucille.davis@email.com");
		Student student2 = new Student("Lynda", "Ross", "lynda.ross@email.com");
		Student student3 = new Student("Edward", "Parks", "edward.parks@email.com");

		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// Create object
		System.out.println("Creating new Student object");
		Student student = new Student("Paul", "Smith", "paul.smith@email.com");

		// Save the object to a database
		System.out.println("Saving the Student object");
		studentDAO.save(student);

		// Confirm object creation
		System.out.println("Student created. Student ID: " + student.getId());
	}
}
