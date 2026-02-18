package com.example.college.repository;

import com.example.college.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository JPA for professor entity
 *
 * @author yfandica
 */
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
