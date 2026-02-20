package com.example.college.mapper;

import com.example.college.dto.*;
import com.example.college.model.Career;
import com.example.college.model.Professor;
import com.example.college.model.Student;

import java.util.List;

/**
 * Mapper for the student entity.
 * Entity to DTO
 * DTO to entity
 * @author yfandica
 */
public class MapperStudent {

    /**
     * Method that transforms data from DTO format
     * to entity format.
     *
     * @author yfandica
     * @param student Object containing student data in entity format.
     * @return Object containing student data in DTO format.
     */
    public static StudentGetDTO toDTO(Student student){

        if(student == null) return null;

        List<SubjectGetDTO> subjectList= student.getCourses()
                .stream().map(course -> MapperSubject.toDTO(course.getSubject()))
                .toList();

        return StudentGetDTO.builder()
                .id(student.getId())
                .fullName(student.getName()+ " " + student.getLastName())
                .age(student.getAge())
                .gender(student.getGender())
                .entryDate(student.getEntryDate())
                .idCareer(student.getCareer().getId())
                .nameCareer(student.getCareer().getName())
                .subjectList(subjectList)
                .build();
    }

    /**
     * Method that transforms data from entity format
     * to DTO format.
     *
     * @author yfandica
     * @param studentPostDTO Object containing student data in DTO format.
     * @return Object containing student data in entity format.
     */
    public static Student toEntity(StudentPostDTO studentPostDTO){
        if(studentPostDTO == null) return null;

        return Student.builder()
                .id(studentPostDTO.getId())
                .name(studentPostDTO.getName())
                .lastName(studentPostDTO.getLastName())
                .age(studentPostDTO.getAge())
                .gender(studentPostDTO.getGender())
                .entryDate(studentPostDTO.getEntryDate())
                .build();
    }
}
