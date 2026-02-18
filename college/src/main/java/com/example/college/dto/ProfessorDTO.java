package com.example.college.dto;


import lombok.*;

import java.util.Date;

/**
 * Class DTO to professor entity
 *
 * @author yfandica
 */
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class ProfessorDTO {

    private Long id;
    private String name;
    private String lastName;
    private Integer age;
    private Date entryDate;

}
