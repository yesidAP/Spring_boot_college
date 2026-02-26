package com.example.college.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Subject is the entity which it represents
 * the entity subject in the database
 *
 * @author yfandica
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Subject {

    /**
     * PK of subject entity
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer credits;

    /**
     * FK for identifying the professor entity
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_professor")
    private Professor professor;

    /**
     * One-to-many relationship of subject entity to course entity
     */
    @OneToMany(mappedBy = "subject", fetch = FetchType.EAGER)
    List<Course> courses = new ArrayList<>();
}
