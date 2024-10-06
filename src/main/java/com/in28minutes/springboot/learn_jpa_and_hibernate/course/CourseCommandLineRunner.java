package com.in28minutes.springboot.learn_jpa_and_hibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import com.in28minutes.springboot.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//	@Autowired
//	private CousreJdbcRepository respository;

//	@Autowired
//	private CourseJpaRepository respository;
//	
	@Autowired
	private CourseSpringDataJpaRepository respository;

	@Override
	public void run(String... args) throws Exception {
//		respository.insert(new Course(1, "Learn aws jpa!", "in 28 minutes"));
//		respository.insert(new Course(2, "Learn Azure jpa!", "in 28 minutes"));
//		respository.insert(new Course(3, "Learn Dev ops jpa!", "in 28 minutes"));
//		respository.deleteById(1);
//		System.out.print(respository.findById(2));
//		System.out.print(respository.findById(3));
		
		respository.save(new Course(1, "Learn aws jpa!", "in 28 minutes"));
		respository.save(new Course(2, "Learn Azure jpa!", "in 28 minutes"));
		respository.save(new Course(3, "Learn Dev ops jpa!", "in 28 minutes"));
		System.out.println(respository.count());

		respository.deleteById(1);
		System.out.print(respository.findById(2));
		System.out.print(respository.findById(3));
		System.out.println(respository.count());
		System.out.println(respository.findByAuthor("in 28 minutes"));
		System.out.println(respository.findByName("Learn Azure jpa!"));

	}
}
