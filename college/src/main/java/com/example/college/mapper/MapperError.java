package com.example.college.mapper;

import com.example.college.dto.ErrorDTO;
import com.example.college.exception.ErrorControllerApi;

public class MapperError {
    /**
     * Method that transforms an Exception message
     * to DTO
     *
     * @author yfandica
     *
     * @param e Object ErrorControllerApi.
     * @return Object containing Error info in DTO format.
     */
    public static ErrorDTO toDTO(ErrorControllerApi e){

        return ErrorDTO.builder()
                .id(e.getCode())
                .message(e.getMessage())
                .build();
    }
}
