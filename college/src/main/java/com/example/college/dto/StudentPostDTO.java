package com.example.college.dto;

import lombok.*;

import java.util.Date;

/**
 * Class DTO to student entity
 * It will be used only for post-service
 *
 * @author yfandica
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentPostDTO {

    private Long id;
    private String name;
    private String lastName;
    private Integer age;
    private Character gender;
    private Date entryDate;
    private Long idCareer;
}
