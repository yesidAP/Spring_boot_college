package com.example.college.mapper;

import com.example.college.dto.*;

import com.example.college.model.Subject;

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

//        List<StudentGetDTO> studentList = new ArrayList<>();
//
//        if (subject.getCourses() != null){
//            studentList = subject.getCourses()
//                    .stream().map(course -> MapperStudent.toDTO(course.getStudent()))
//                    .toList();
//        }

        return SubjectGetDTO.builder()
                .id(subject.getId())
                .name(subject.getName())
                .credits(subject.getCredits())
                .professorDTO(professorDTO)
                //.studentList(studentList)
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
        if(subjectPostDTO == null) {
            return null;
        }

        return Subject.builder()
                .id(subjectPostDTO.getId())
                .name(subjectPostDTO.getName())
                .credits(subjectPostDTO.getCredits())
                .build();
    }

    /**
     * Method that assesses whether all attributes of the DTO
     * are null or all have their respective value.
     *
     * @author yfandica
     *
     * @param s Object of SubjectPostDTO
     * @return true if it is empty / false if it has all the values
     */
    public static boolean isEmpty(SubjectPostDTO s){

        if (s.getName()== null && s.getIdProfessor()== null
                && s.getCredits() == null ){
            return true;
        }

        return false;
    }
}
