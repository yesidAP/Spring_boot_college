package com.example.college.mapper;

import com.example.college.dto.*;
import com.example.college.model.Professor;
import com.example.college.model.Student;
import com.example.college.model.Subject;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper for the subject entity.
 * Entity to DTO
 * DTO to entity
 * @author yfandica
 */
public class MapperSubject {

    /**
     * Method that transforms data from entity format
     * to DTO format
     *
     * @author yfandica
     * @param subject Object containing subject data in entity format.
     * @return Object containing subject data in DTO format.
     */
    public static SubjectGetDTO toDTO(Subject subject){

        if(subject == null) return null;

        ProfessorDTO professorDTO = MapperProfessor.toDTO(subject.getProfessor());

        List<StudentGetDTO> studentList = subject.getCourses()
                .stream().map(course -> MapperStudent.toDTO(course.getStudent()))
                .toList();

        return SubjectGetDTO.builder()
                .id(subject.getId())
                .name(subject.getName())
                .credits(subject.getCredits())
                .professorDTO(professorDTO)
                .studentList(studentList)
                .build();
    }

    /**
     * Method that transforms data from DTO format
     * to entity format.
     *
     * @author yfandica
     * @param subjectPostDTO Object containing subject data in DTO format.
     * @return Object containing subject data in entity format.
     */
    public static Subject toEntity(SubjectPostDTO subjectPostDTO){
        if(subjectPostDTO == null) return null;

        return Subject.builder()
                .id(subjectPostDTO.getId())
                .name(subjectPostDTO.getName())
                .credits(subjectPostDTO.getCredits())
                .build();
    }
}
