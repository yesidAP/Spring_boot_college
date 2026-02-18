package com.example.college.service.interfacesServ;

import com.example.college.dto.CareerDTO;
import com.example.college.dto.SubjectGetDTO;
import com.example.college.dto.SubjectPostDTO;

import java.util.List;

/**
 * Interface that defines the methods that
 * will be used by the CareerService class.
 *
 * @author yfandica
 */
public interface ICareerService {
    /**
     * Method that search and display the
     * careers that exits in the database career.
     *
     * @author yfandica
     * @return List of Career with complete information.
     */
    List<CareerDTO> getCareers();

    /**
     * Method that save in the database
     * a new element of career entity.
     *
     * @author yfandica
     * @param careerDTO Object dto of career to save in database.
     * @return The career that was recently created in DTO form.
     */
    CareerDTO postCareer(CareerDTO careerDTO);

    /**
     *Update an existing element of the career entity
     *
     * @author yfandica
     * @param id Pk of an element of career entity
     * @param careerDTO Object dto of career to update in database.
     * @return The career that was recently created in DTO form.
     */
    CareerDTO putCareer(Long id, CareerDTO careerDTO);

    /**
     * Delete an existing element of the career entity
     *
     * @author yfandica
     * @param id Pk of an element of career entity
     */
    void deleteCareer(Long id);
}
