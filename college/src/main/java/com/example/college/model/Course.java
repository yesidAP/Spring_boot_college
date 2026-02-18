package com.example.college.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * Class Course is the entity which it represents
 * the entity course in the database
 *
 * @author yfandica
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Course {

    /**
     * PK of subject entity
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * FK for identifying the student entity
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_student")
    private Student student;


    /**
     * FK for identifying the subject entity
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subject")
    private Subject subject;

    private Double score;
}
