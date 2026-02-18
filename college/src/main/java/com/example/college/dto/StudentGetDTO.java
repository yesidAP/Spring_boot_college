package com.example.college.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * Class DTO to student entity
 * It will be used only for get-service
 *
 * @author yfandica
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentGetDTO {

    private Long id;
    private String fullName;
    private Integer age;
    private Character gender;
    private Date entryDate;
    private Long idCareer;
    private String nameCareer;

    //list all students' subjects
    List<SubjectGetDTO> subjectList ;

}
