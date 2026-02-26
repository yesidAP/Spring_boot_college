package com.example.college.controller;

import com.example.college.Enum.ErrorApi;
import com.example.college.dto.ErrorDTO;
import com.example.college.dto.ProfessorDTO;
import com.example.college.exception.ErrorControllerApi;
import com.example.college.mapper.MapperError;
import com.example.college.service.interfacesServ.IProfessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * Class controller for Professor,
 * Handles REST API requests:
 * GET, POST, PUT and DELETE
 *
 * @author yfandica
 */
@RestController
@RequestMapping("api/professors")
public class ProfessorController {

    @Autowired
    IProfessor professorService;


    /**
     * A GET request for the Professor entity
     *
     * @author yfandica
     *
     * @return Returns code 200 (Success)
     * if there are no problems with the request, along
     * a list of stored data for the Career entity.
     */
    @GetMapping
    public ResponseEntity<List<ProfessorDTO>> getProfessor(){
        return ResponseEntity.ok(professorService.getProfessor());
    }

    /**
     * A POST request for the Professor entity
     *
     * @author yfandica
     *
     * @param professorDTO Data of Professor entity in DTO format
     *
     * @return Code 201 (Created)
     * if there are no problems with the request, along with the URI and the
     * information of the data that was created.
     * Code 400 (Bad request)
     * if there are problems with the request, along with a possible error message
     */
    @PostMapping
    public ResponseEntity<?> postProfessor(@RequestBody ProfessorDTO professorDTO){

        try {
            ProfessorDTO p = professorService.postProfessor(professorDTO);

            return ResponseEntity.created(URI.create("api/career"+p.getId())).body(p);

        }catch (ErrorControllerApi e){
            ErrorDTO errorDTO = MapperError.toDTO(e);
            return ResponseEntity.badRequest().body(errorDTO);
        }catch (Exception e){
            ErrorDTO errorDTO = MapperError.toDTO(new ErrorControllerApi(ErrorApi.DATA_INTEGRITY));
            return ResponseEntity.badRequest().body(errorDTO);
        }

    }

    /**
     * A PUT request for the Professor entity
     *
     * @author yfandica
     *
     * @param id Primary key of a register
     * @param professorDTO Data of Professor entity in DTO format
     *
     * @return Code 200 (Success)
     * if there are no problems with the request, along with
     * information of the data that was created.
     * Code 400 (Bad request)
     * if there are problems with the request, along with a possible error message.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> putProfessor(@PathVariable Long id,
                                       @RequestBody ProfessorDTO professorDTO){
        try {
            ProfessorDTO p = professorService.putProfessor(id, professorDTO);

            return ResponseEntity.ok(p);

        }catch (ErrorControllerApi e){
            ErrorDTO errorDTO = MapperError.toDTO(e);
            return ResponseEntity.badRequest().body(errorDTO);
        }catch (Exception e){
            ErrorDTO errorDTO = MapperError.toDTO(new ErrorControllerApi(ErrorApi.DATA_INTEGRITY));
            return ResponseEntity.badRequest().body(errorDTO);
        }

    }

    /**
     * A DELETE request for the Professor entity
     *
     * @author yfandica
     *
     * @param id Primary key of a register
     *
     * @return Code 204(No Content)
     * if there are no problems with the request.
     * Code 400 (Bad request)
     * if there are problems with the request, along with a possible error message
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfessor(@PathVariable Long id){
        try {
            professorService.deleteProfessor(id);
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
