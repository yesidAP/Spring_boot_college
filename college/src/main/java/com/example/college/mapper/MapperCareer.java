package com.example.college.mapper;

import com.example.college.dto.CareerDTO;
import com.example.college.model.Career;

/**
 * Mapper for the career entity.
 * Entity to DTO
 * DTO to entity
 * @author yfandica
 */
public class MapperCareer {

    /**
     * Method that transforms data from entity format
     * to DTO format
     *
     * @author yfandica
     * @param career Object containing career data in entity format.
     * @return Object containing career data in DTO format.
     */
    public static CareerDTO toDTO(Career career){

        if(career == null) return null;

        return CareerDTO.builder()
                .id(career.getId())
                .name(career.getName())
                .build();
    }

    /**
     * Method that transforms data from DTO format
     * to entity format.
     *
     * @author yfandica
     * @param careerDTO Object containing career data in DTO format.
     * @return Object containing career data in entity format.
     */
    public static Career toEntity(CareerDTO careerDTO){
        if(careerDTO == null) return null;

        return Career.builder()
                .id(careerDTO.getId())
                .name(careerDTO.getName())
                .build();
    }
}
