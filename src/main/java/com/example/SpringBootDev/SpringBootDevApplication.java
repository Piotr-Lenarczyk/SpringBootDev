package com.example.SpringBootDev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDevApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDevApplication.class, args);
	}

    // @Bean
    // public CommandLineRunner commandLineRunner(InstructorService instructorService) {
    // 	return runner -> {
    // 		// Instructor instructor = new Instructor("first", "last", "email");
    // 		// InstructorDetail instructorDetail = new InstructorDetail("name", "hobby");
    // 		// instructor.setInstructorDetail(instructorDetail);
    // 		// System.out.println("Attempting to save " + instructor);
    // 		// instructorService.save(instructor);
    // 		// System.exit(0);
//
    // 		// System.out.println("Attempting to find the instructor with ID 1");
    // 		// Instructor instructor = instructorService.findById(1);
    // 		// if (instructor != null) {
    // 		// 	System.out.println(instructor);
    // 		// } else {
    // 		// 	System.out.println("Retrieval failed");
    // 		// }
    // 		// System.exit(0);
//
    // 		// int id = 1;
    // 		// System.out.println("Attempting to delete instructor with ID " + id);
    // 		// try {
    // 		// 	instructorService.deleteById(id);
    // 		// } catch (IllegalArgumentException e) {
    // 		// 	System.out.println(e.getMessage());
    // 		// }
    // 		// System.exit(0);
    //     };
    // }
}
