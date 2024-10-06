package com.in28minutes.springboot.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learn_jpa_and_hibernate.course.Course;

@Repository
public class CousreJdbcRepository {

	private static String INSERT_QUERY = """
			insert into course (id, name, author)
			values(?, ?, ?);
			""";
	
	private static String DELETE_QUERY="""
			delete from course where id =?;
			""";
	
	private static String SELECT_ALL="""
			select * from course where id =?;
			""";
	@Autowired
	private JdbcTemplate springJdbcTemplate;

	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
	}
	
	public void deleteById(int id) {
		springJdbcTemplate.update(DELETE_QUERY, id);
	}
	
	public Course findById(int id) {
		//ResultSet -> Bean => Row Mapper =>
		return springJdbcTemplate.queryForObject(SELECT_ALL, new BeanPropertyRowMapper<>(Course.class), id);
	}
}
