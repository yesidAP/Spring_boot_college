package com.example.college.dto;

import lombok.*;
/**
 * Class DTO to subject entity
 * It will be used only for get-service
 *
 * @author yfandica
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectGetDTO {

    private Long id;
    private String name;
    private Integer credits;
    private ProfessorDTO professorDTO;


}
