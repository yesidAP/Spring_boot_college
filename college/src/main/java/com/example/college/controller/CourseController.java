package com.example.college.controller;

import com.example.college.Enum.ErrorApi;
import com.example.college.dto.CourseGetDTO;
import com.example.college.dto.CoursePostDTO;
import com.example.college.dto.ErrorDTO;
import com.example.college.exception.ErrorControllerApi;
import com.example.college.mapper.MapperError;
import com.example.college.service.interfacesServ.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * Class controller for Course,
 * Handles REST API requests:
 * GET, POST, PUT and DELETE
 *
 * @author yfandica
 */
@RestController
@RequestMapping("api/courses")
public class CourseController {

    @Autowired
    ICourseService courseService;

    /**
     * A GET request for the Course entity
     *
     * @author yfandica
     *
     * @return Returns code 200 (Success)
     * if there are no problems with the request, along
     * a list of stored data for the Course entity.
     */
    @GetMapping
    public ResponseEntity<List<CourseGetDTO>> getCourses(){
        return ResponseEntity.ok(courseService.getCourses());
    }

    /**
     * A POST request for the Course entity
     *
     * @author yfandica
     *
     * @param coursePostDTO Data of Course entity in DTO format
     *
     * @return Code 201 (Created)
     * if there are no problems with the request, along with the URI and the
     * information of the data that was created.
     *Code 400 (Bad request)
     * if there are problems with the request, along with a possible error message
     */
    @PostMapping
    public ResponseEntity<?> postCourse(@RequestBody CoursePostDTO coursePostDTO){

        try {
            CourseGetDTO c = courseService.postCourse(coursePostDTO);

            return ResponseEntity.created(URI.create("api/courses"+c.getId())).body(c);

        }catch (ErrorControllerApi e){
            ErrorDTO errorDTO = MapperError.toDTO(e);
            return ResponseEntity.badRequest().body(errorDTO);
        }catch (Exception e){
            ErrorDTO errorDTO = MapperError.toDTO(new ErrorControllerApi(ErrorApi.DATA_INTEGRITY));
            return ResponseEntity.badRequest().body(errorDTO);
        }

    }

    /**
     * A PUT request for the Course entity
     *
     * @author yfandica
     *
     * @param id Primary key of a register
     * @param coursePostDTO Data of Course entity in DTO format
     *
     * @return Code 200 (Success)
     * if there are no problems with the request, along with
     * information of the data that was created.
     *Code 400 (Bad request)
     * if there are problems with the request, along with a possible error message.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> putCourse(@PathVariable Long id,
                                       @RequestBody CoursePostDTO coursePostDTO){
        try {
            CourseGetDTO c = courseService.putCourse(id, coursePostDTO);

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
     * A DELETE request for the Course entity
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
    public ResponseEntity<?> deleteCourse(@PathVariable Long id){
        try {
            courseService.deleteCourse(id);
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
