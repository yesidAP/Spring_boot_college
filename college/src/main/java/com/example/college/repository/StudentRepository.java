package com.example.college.repository;

import com.example.college.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository JPA for Student entity
 *
 * @author yfandica
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
