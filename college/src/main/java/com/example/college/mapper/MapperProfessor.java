package com.example.college.mapper;

import com.example.college.dto.ProfessorDTO;
import com.example.college.model.Professor;

/**
 * Mapper for the professor entity.
 * Entity to DTO
 * DTO to entity
 * @author yfandica
 */
public class MapperProfessor {

    /**
     * Method that transforms data from entity format
     * to DTO format
     *
     * @author yfandica
     * @param professor Object containing professor data in entity format.
     * @return Object containing professor data in DTO format.
     */
    public static ProfessorDTO toDTO(Professor professor){

        if(professor == null) return null;

        return ProfessorDTO.builder()
                .id(professor.getId())
                .name(professor.getName())
                .lastName(professor.getLastName())
                .age(professor.getAge())
                .entryDate(professor.getEntryDate())
                .build();
    }

    /**
     * Method that transforms data from DTO format
     * to entity format.
     *
     * @author yfandica
     * @param professorDTO Object containing professor data in DTO format.
     * @return Object containing professor data in entity format.
     */
    public static Professor toEntity(ProfessorDTO professorDTO){
        if(professorDTO == null) return null;

        return Professor.builder()
                .id(professorDTO.getId())
                .name(professorDTO.getName())
                .lastName(professorDTO.getLastName())
                .age(professorDTO.getAge())
                .entryDate(professorDTO.getEntryDate())
                .build();
    }

    /**
     * Method that assesses whether all attributes of the DTO
     * are null or all have their respective value.
     *
     * @author yfandica
     *
     * @param p Object of ProfessorDTO
     * @return true if it is empty / false if it has all the values
     */
    public static boolean isEmpty(ProfessorDTO p){

        if (p.getName() == null && p.getLastName() == null
                && p.getAge() == null && p.getEntryDate() == null ){
            return true;
        }

        return false;

    }
}
