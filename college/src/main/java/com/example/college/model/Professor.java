package com.example.college.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

/**
 * Class Professor is the entity which it represents
 * the entity Professor in the database
 *
 * @author yfandica
 */
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
@Entity
public class Professor {

    /**
     * PK of professor entity
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "last_name")
    private String lastName;
    private Integer age;
    @Column(name = "entry_date")
    private Date entryDate;
}
