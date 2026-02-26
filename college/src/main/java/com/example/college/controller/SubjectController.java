package com.example.college.controller;

import com.example.college.Enum.ErrorApi;
import com.example.college.dto.ErrorDTO;
import com.example.college.dto.SubjectGetDTO;
import com.example.college.dto.SubjectPostDTO;
import com.example.college.exception.ErrorControllerApi;
import com.example.college.mapper.MapperError;
import com.example.college.service.interfacesServ.ISubjectService;
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
@RequestMapping("api/subjects")
public class SubjectController {

    @Autowired
    ISubjectService subjectService;


    /**
     * A GET request for the Subject entity
     *
     * @author yfandica
     *
     * @return Returns code 200 (Success)
     * if there are no problems with the request, along
     * a list of stored data for the Subject entity.
     */
    @GetMapping
    public ResponseEntity<List<SubjectGetDTO>> getSubjects(){
        return ResponseEntity.ok(subjectService.getSubjects());
    }

    /**
     * A POST request for the Subject entity
     *
     * @author yfandica
     *
     * @param subjectPostDTO Data of Subject entity in DTO format
     *
     * @return Code 201 (Created)
     * if there are no problems with the request, along with the URI and the
     * information of the data that was created.
     * Code 400 (Bad request)
     * if there are problems with the request, along with a possible error message
     */
    @PostMapping
    public ResponseEntity<?> postSubject(@RequestBody SubjectPostDTO subjectPostDTO){

        try {
            SubjectGetDTO s = subjectService.postSubject(subjectPostDTO);

            return ResponseEntity.created(URI.create("api/career"+s.getId())).body(s);

        }catch (ErrorControllerApi e){
            ErrorDTO errorDTO = MapperError.toDTO(e);
            return ResponseEntity.badRequest().body(errorDTO);
        }catch (Exception e){
            ErrorDTO errorDTO = MapperError.toDTO(new ErrorControllerApi(ErrorApi.DATA_INTEGRITY));
            return ResponseEntity.badRequest().body(errorDTO);
        }

    }

    /**
     * A PUT request for the Subject entity
     *
     * @author yfandica
     *
     * @param id Primary key of a register
     * @param subjectPostDTO Data of Subject entity in DTO format
     *
     * @return Code 200 (Success)
     * if there are no problems with the request, along with
     * information of the data that was created.
     * Code 400 (Bad request)
     * if there are problems with the request, along with a possible error message.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> putProfessor(@PathVariable Long id,
                                          @RequestBody SubjectPostDTO subjectPostDTO){
        try {
            SubjectGetDTO s = subjectService.putSubject(id, subjectPostDTO);

            return ResponseEntity.ok(s);

        }catch (ErrorControllerApi e){
            ErrorDTO errorDTO = MapperError.toDTO(e);
            return ResponseEntity.badRequest().body(errorDTO);
        }catch (Exception e){
            ErrorDTO errorDTO = MapperError.toDTO(new ErrorControllerApi(ErrorApi.DATA_INTEGRITY));
            return ResponseEntity.badRequest().body(errorDTO);
        }

    }

    /**
     * A DELETE request for the Subject entity
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
            subjectService.deleteSubject(id);
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
