package com.example.college.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"id_student", "id_subject"}  ))
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
    @OnDelete(action = OnDeleteAction.RESTRICT)
    private Student student;


    /**
     * FK for identifying the subject entity
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subject")
    @OnDelete(action = OnDeleteAction.RESTRICT)
    private Subject subject;

    private Double score;
}
