package com.example.college.service.interfacesServ;

import com.example.college.dto.CourseGetDTO;
import com.example.college.dto.ProfessorDTO;
import com.example.college.dto.ProfessorDTO;

import java.util.List;

/**
 * Interface that defines the methods that
 * will be used by the ProfessorService class.
 *
 * @author yfandica
 */
public interface IProfessor {
    /**
     * Method that search and display the
     * Professor that exits in the database professor.
     * @author yfandica
     * @return List of professor with complete information.
     */
    List<ProfessorDTO> getProfessor();

    /**
     * Method that save in the database
     * a new element of professor entity.
     *
     * @author yfandica
     * @param professorDTO Object dto of professor to save in database.
     * @return The professor that was recently created in DTO form.
     */
    ProfessorDTO postProfessor(ProfessorDTO professorDTO);

    /**
     *Update an existing element of the professor entity
     *
     * @author yfandica
     * @param id Pk of an element of professor entity
     * @param professorDTO Object dto of professor to update in database.
     * @return The professor that was recently created in DTO form.
     */
    ProfessorDTO putProfessor(Long id, ProfessorDTO professorDTO);

    /**
     * Delete an existing element of the professor entity
     *
     * @author yfandica
     * @param id Pk of an element of professor entity
     */
    void deleteProfessor(Long id);
}
