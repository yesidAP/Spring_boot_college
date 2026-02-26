package com.example.college.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class Student is the entity which it represents
 * the entity student in the database
 *
 * @author yfandica
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Student {

    /**
     * PK of student entity
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "last_name")
    private String lastName;
    private Integer age;
    private Character gender;
    @Column(name = "entry_date")
    private Date entryDate;

    /**
     * FK for identifying the career entity
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_career")
    private Career career;

    /**
     * One-to-many relationship of student entity to course entity
     */
    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    List<Course> courses = new ArrayList<>();


}
