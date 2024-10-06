package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {

	@PersistenceContext
	private EntityManager entityManger;

	public void insert(Course course) {
		entityManger.merge(course);
	}

	public Course findById(int id) {
		return entityManger.find(Course.class, id);
	}

	public void deleteById(int id) {
		Course course = entityManger.find(Course.class, id);
		entityManger.remove(course);
	}
}
