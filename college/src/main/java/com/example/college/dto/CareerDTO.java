package com.example.college.dto;

import lombok.*;

/**
 * Class DTO to career entity
 *
 * @author yfandica
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CareerDTO {
    private Long id;
    private String name;
}
