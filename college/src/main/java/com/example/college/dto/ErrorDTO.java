package com.example.college.dto;

import lombok.*;

/**
 * DTO helper class to send error details to RESTful services.
 *
 * @author yfandica
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDTO {

    private Integer id;
    private String message;

}
