package com.example.college.mapper;

import com.example.college.dto.CourseGetDTO;
import com.example.college.dto.CoursePostDTO;
import com.example.college.model.Course;

/**
 * Mapper for the Course entity.
 * Entity to DTO
 * DTO to entity
 * @author yfandica
 */
public class MapperCourse {

    /**
     * Method that transforms data from entity format
     * to DTO format
     *
     * @author yfandica
     * @param course Object containing course data in entity format.
     * @return Object containing course data in DTO format.
     */
    public static CourseGetDTO toDTO(Course course){

        if(course == null) return null;

        return CourseGetDTO.builder()
                .id(course.getId())
                .idStudent(course.getStudent().getId())
                .idSubject(course.getSubject().getId())
                .fullNameStudent(course.getStudent().getName()+" "+course.getStudent().getLastName() )
                .nameSubject(course.getSubject().getName())
                .score(course.getScore())
                .build();
    }

    /**
     * Method that transforms data from DTO format
     * to entity format.
     *
     * @author yfandica
     * @param coursePostDTO Object containing course data in DTO format.
     * @return Object containing course data in entity format.
     */
    public static Course toEntity(CoursePostDTO coursePostDTO){

        if(coursePostDTO == null) return null;

        return Course.builder()
                .id(coursePostDTO.getId())
                .score(coursePostDTO.getScore())
                .build();
    }

    /**
     * Method that assesses whether all attributes of the DTO
     * are null or all have their respective value.
     *
     * @author yfandica
     *
     * @param c Object of CoursePostDTO
     * @return true if it is empty / false if it has all the values
     */
    public static boolean isEmpty(CoursePostDTO c){

        if (c.getIdStudent() == null && c.getIdSubject() == null
                && c.getScore()== null ){
            return true;
        }

        return false;
    }
}
