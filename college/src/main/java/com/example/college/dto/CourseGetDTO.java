package com.example.college.dto;

import lombok.*;

/**
 * Class DTO to course entity
 * It will be used only for get-service
 *
 * @author yfandica
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseGetDTO {

    private Long id;
    private Long idStudent;
    private String fullNameStudent;
    private Long idSubject;
    private String nameSubject;
    private Double score;
}
