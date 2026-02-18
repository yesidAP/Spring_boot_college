package com.example.college.repository;

import com.example.college.model.Career;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository JPA for career entity
 *
 * @author yfandica
 */
public interface CareerRepository extends JpaRepository<Career,Long> {
}
