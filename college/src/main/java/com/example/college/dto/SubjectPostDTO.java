package com.example.college.dto;

import lombok.*;

/**
 * Class DTO to subject entity
 * It will be used only for post-service
 *
 * @author yfandica
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectPostDTO {
    
    private Long id;
    private String name;
    private Integer credits;
    private Long idProfessor;
}
