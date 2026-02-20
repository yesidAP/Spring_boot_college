package com.example.college.service.interfacesServ;

import com.example.college.dto.CourseGetDTO;
import com.example.college.dto.CoursePostDTO;

import java.util.List;

/**
 * Interface that defines the methods that
 * will be used by the CourseService class.
 *
 * @author yfandica
 */
public interface ICourseService {
    /**
     * Method that search and display the
     * Courses that exits in the database course.
     * @author yfandica
     * @return List of course with complete information.
     */
    List<CourseGetDTO> getCourses();

    /**
     * Method that save in the database
     * a new element of course entity.
     *
     * @author yfandica
     * @param coursePostDTO Object dto of course to save in database.
     * @return The course that was recently created in DTO form.
     */
    CourseGetDTO postCourse(CoursePostDTO coursePostDTO);

    /**
     *Update an existing element of the course entity
     *
     * @author yfandica
     * @param id Pk of an element of course entity
     * @param coursePostDTO Object dto of course to update in database.
     * @return The course that was recently created in DTO form.
     */
    CourseGetDTO putCourse(Long id, CoursePostDTO coursePostDTO);

    /**
     * Delete an existing element of the course entity
     *
     * @author yfandica
     * @param id Pk of an element of course entity
     */
    void deleteCourse(Long id);
}
