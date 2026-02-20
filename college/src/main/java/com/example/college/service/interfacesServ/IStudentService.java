package com.example.college.service.interfacesServ;

import com.example.college.dto.StudentPostDTO;
import com.example.college.dto.StudentGetDTO;

import java.util.List;

/**
 * Interface that defines the methods that
 * will be used by the StudentService class.
 *
 * @author yfandica
 */
public interface IStudentService {
    /**
     * Method that search and display the
     * Students that exits in the database student.
     * @author yfandica
     * @return List of student with complete information.
     */
    List<StudentGetDTO> getStudent();

    /**
     * Method that save in the database
     * a new element of student entity.
     *
     * @author yfandica
     * @param studentPostDTO Object dto of student to save in database.
     * @return The student that was recently created in DTO form.
     */
    StudentGetDTO postStudent(StudentPostDTO studentPostDTO);

    /**
     *Update an existing element of the student entity
     *
     * @author yfandica
     * @param id Pk of an element of student entity
     * @param studentPostDTO Object dto of student to update in database.
     * @return The student that was recently created in DTO form.
     */
    StudentGetDTO putStudent(Long id, StudentPostDTO studentPostDTO);

    /**
     * Delete an existing element of the student entity
     *
     * @author yfandica
     * @param id Pk of an element of student entity
     */
    void deleteStudent(Long id);
}
