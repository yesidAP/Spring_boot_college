package com.example.college.repository;

import com.example.college.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository JPA for subject entity
 *
 * @author yfandica
 */
public interface SubjectRepository extends JpaRepository<Subject, Long>{
}
