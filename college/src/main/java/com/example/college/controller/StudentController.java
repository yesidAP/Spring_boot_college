package com.example.college.controller;

import com.example.college.Enum.ErrorApi;
import com.example.college.dto.*;
import com.example.college.exception.ErrorControllerApi;
import com.example.college.mapper.MapperError;
import com.example.college.service.interfacesServ.IStudentService;
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
@RequestMapping("api/students")
public class StudentController {
    @Autowired
    IStudentService studentService;

    /**
     * A GET request for the Student entity
     *
     * @author yfandica
     *
     * @return Returns code 200 (Success)
     * if there are no problems with the request, along
     * a list of stored data for the Student entity.
     */
    @GetMapping
    public ResponseEntity<List<StudentGetDTO>> getStudents(){
        return ResponseEntity.ok(studentService.getStudent());
    }

    /**
     * A POST request for the Student entity
     *
     * @author yfandica
     *
     * @param studentPostDTO Data of Student entity in DTO format
     *
     * @return Code 201 (Created)
     * if there are no problems with the request, along with the URI and the
     * information of the data that was created.
     * Code 400 (Bad request)
     * if there are problems with the request, along with a possible error message
     */
    @PostMapping
    public ResponseEntity<?> postStudent(@RequestBody StudentPostDTO studentPostDTO){

        try {
            StudentGetDTO s = studentService.postStudent(studentPostDTO);

            return ResponseEntity.created(URI.create("api/students"+s.getId())).body(s);

        }catch (ErrorControllerApi e){
            ErrorDTO errorDTO = MapperError.toDTO(e);
            return ResponseEntity.badRequest().body(errorDTO);
        }catch (Exception e){
            ErrorDTO errorDTO = MapperError.toDTO(new ErrorControllerApi(ErrorApi.DATA_INTEGRITY));
            return ResponseEntity.badRequest().body(errorDTO);
        }

    }

    /**
     * A PUT request for the Student entity
     *
     * @author yfandica
     *
     * @param id Primary key of a register
     * @param studentPostDTO Data of Student entity in DTO format
     *
     * @return Code 200 (Success)
     * if there are no problems with the request, along with
     * information of the data that was created.
     * Code 400 (Bad request)
     * if there are problems with the request, along with a possible error message.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> putStudent(@PathVariable Long id,
                                          @RequestBody StudentPostDTO studentPostDTO){
        try {
            StudentGetDTO s = studentService.putStudent(id, studentPostDTO);

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
     * A DELETE request for the Student entity
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
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        try {
            studentService.deleteStudent(id);
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
