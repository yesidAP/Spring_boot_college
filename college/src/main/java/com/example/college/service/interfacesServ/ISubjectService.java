package com.example.college.service.interfacesServ;

import com.example.college.dto.SubjectGetDTO;
import com.example.college.dto.SubjectPostDTO;

import java.util.List;

/**
 * Interface that defines the methods that
 * will be used by the SubjectService class.
 *
 * @author yfandica
 */
public interface ISubjectService {

    /**
     * Method that search and display the
     * subjects that exits in the database
     *
     * @author yfandica
     * @return List of Subjects with complete information.
     */
    List<SubjectGetDTO> getSubjects();

    /**
     * Method that save in the database
     * a new element of entity subject
     *
     * @author yfandica
     * @param subjectPostDTO Object dto of subject to save in database.
     * @return The subject that was recently created in DTO form.
     */
    SubjectGetDTO postSubject(SubjectPostDTO subjectPostDTO);

    /**
     *Update an existing element of the subject entity
     *
     * @author yfandica
     * @param id Pk of an element of subject entity
     * @param SubjectPostDTO Object dto of subject to update in database.
     * @return The subject that was recently created in DTO form.
     */
    SubjectGetDTO putSubject(Long id, SubjectPostDTO SubjectPostDTO);

    /**
     * Delete an existing element of the subject entity
     *
     * @author yfandica
     * @param id Pk of an element of subject entity
     */
    void deleteSubject(Long id);

}
