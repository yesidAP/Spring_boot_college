package com.example.college.dto;

import lombok.*;

/**
 * Class DTO to course entity
 * It will be used only for post-service
 *
 * @author yfandica
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoursePostDTO {

    private Long id;
    private Long idStudent;
    private Long idSubject;
    private Double score;

}
