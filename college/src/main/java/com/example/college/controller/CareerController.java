package com.example.college.controller;

import com.example.college.Enum.ErrorApi;
import com.example.college.dto.CareerDTO;
import com.example.college.dto.ErrorDTO;
import com.example.college.exception.ErrorControllerApi;
import com.example.college.mapper.MapperError;
import com.example.college.service.interfacesServ.ICareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * Class controller for Career,
 * Handles REST API requests:
 * GET, POST, PUT and DELETE
 *
 * @author yfandica
 */
@RestController
@RequestMapping("api/careers")
public class CareerController {

    @Autowired
    ICareerService careerService;


    /**
     * A GET request for the Career entity
     *
     * @author yfandica
     *
     * @return Returns code 200 (Success)
     * if there are no problems with the request, along
     * a list of stored data for the Career entity.
     */
    @GetMapping
    public ResponseEntity<List<CareerDTO>> getCareer(){
        return ResponseEntity.ok(careerService.getCareers());
    }

    /**
     * A POST request for the Career entity
     *
     * @author yfandica
     *
     * @param careerDTO Data of Career entity in DTO format
     *
     * @return Code 201 (Created)
     * if there are no problems with the request, along with the URI and the
     * information of the data that was created.
     *Code 400 (Bad request)
     * if there are problems with the request, along with a possible error message
     */
    @PostMapping
    public ResponseEntity<?> postCareer(@RequestBody CareerDTO careerDTO){

        try {
            CareerDTO c = careerService.postCareer(careerDTO);

            return ResponseEntity.created(URI.create("api/careers"+c.getId())).body(c);

        }catch (ErrorControllerApi e){
            ErrorDTO errorDTO = MapperError.toDTO(e);
            return ResponseEntity.badRequest().body(errorDTO);
        }catch (Exception e){
            ErrorDTO errorDTO = MapperError.toDTO(new ErrorControllerApi(ErrorApi.DATA_INTEGRITY));
            return ResponseEntity.badRequest().body(errorDTO);
        }

    }

    /**
     * A PUT request for the Career entity
     *
     * @author yfandica
     *
     * @param id Primary key of a register
     * @param careerDTO Data of Career entity in DTO format
     *
     * @return Code 200 (Success)
     * if there are no problems with the request, along with
     * information of the data that was created.
     *Code 400 (Bad request)
     * if there are problems with the request, along with a possible error message.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> putCareer(@PathVariable Long id,
                                               @RequestBody CareerDTO careerDTO){
        try {
            CareerDTO c = careerService.putCareer(id, careerDTO);

            return ResponseEntity.ok(c);

        }catch (ErrorControllerApi e){
            ErrorDTO errorDTO = MapperError.toDTO(e);
            return ResponseEntity.badRequest().body(errorDTO);
        }catch (Exception e){
            ErrorDTO errorDTO = MapperError.toDTO(new ErrorControllerApi(ErrorApi.DATA_INTEGRITY));
            return ResponseEntity.badRequest().body(errorDTO);
        }

    }


    /**
     * A DELETE request for the Career entity
     *
     * @author yfandica
     *
     * @param id Primary key of a register
     *
     * @return Code 204(No Content)
     * if there are no problems with the request.
     *Code 400 (Bad request)
     * if there are problems with the request, along with a possible error message
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCareer(@PathVariable Long id){
        try {
            careerService.deleteCareer(id);
            return ResponseEntity.noContent().build();

        }catch (ErrorControllerApi e){
            ErrorDTO errorDTO = MapperError.toDTO(e);
            return ResponseEntity.badRequest().body(errorDTO);
        }catch (Exception e){
            ErrorDTO errorDTO = MapperError.toDTO(new ErrorControllerApi(ErrorApi.DATA_INTEGRITY));
            return ResponseEntity.badRequest().body(errorDTO);
        }
    }

}
