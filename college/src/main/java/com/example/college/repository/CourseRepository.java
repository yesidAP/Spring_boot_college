package com.example.college.repository;

import com.example.college.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository JPA for course entity
 *
 * @author yfandica
 */
public interface CourseRepository extends JpaRepository<Course, Long> {
}
