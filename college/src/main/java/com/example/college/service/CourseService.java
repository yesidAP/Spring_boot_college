package com.example.college.service;

import com.example.college.Enum.ErrorApi;
import com.example.college.dto.CourseGetDTO;
import com.example.college.dto.CoursePostDTO;
import com.example.college.exception.ErrorControllerApi;
import com.example.college.mapper.MapperCourse;
import com.example.college.model.Course;
import com.example.college.model.Student;
import com.example.college.model.Subject;
import com.example.college.repository.CourseRepository;
import com.example.college.repository.StudentRepository;
import com.example.college.repository.SubjectRepository;
import com.example.college.service.interfacesServ.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for Course entity
 * @author yfandica
 */
@Service
public class CourseService implements ICourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public List<CourseGetDTO> getCourses() {

        List<CourseGetDTO> listCourse = courseRepository
                .findAll()
                .stream()
                .map(MapperCourse::toDTO)
                .toList();

        return listCourse;
    }

    @Override
    public CourseGetDTO postCourse(CoursePostDTO coursePostDTO) {

        if (coursePostDTO == null) throw new ErrorControllerApi(ErrorApi.INVALID_INPUT);

        Course course = MapperCourse.toEntity(coursePostDTO);

        Student student = studentRepository
                .findById(coursePostDTO.getIdStudent())
                .orElseThrow(() -> new ErrorControllerApi(ErrorApi.NOT_EXITS_DATA));

        Subject subject = subjectRepository
                .findById(coursePostDTO.getIdSubject())
                .orElseThrow(() -> new ErrorControllerApi(ErrorApi.NOT_EXITS_DATA));

        course.setStudent(student);
        course.setSubject(subject);

        courseRepository.save(course);

        return MapperCourse.toDTO(course);
    }

    @Override
    public CourseGetDTO putCourse(Long id, CoursePostDTO coursePostDTO) {

        if (coursePostDTO == null) throw new ErrorControllerApi(ErrorApi.INVALID_INPUT);

        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ErrorControllerApi(ErrorApi.NOT_EXITS_DATA));

        if (coursePostDTO.getIdSubject() != null || coursePostDTO.getIdStudent() != null ){
            throw new ErrorControllerApi(ErrorApi.NO_CHANGE_ID);
        }

        if (coursePostDTO.getScore() != null ){
            course.setScore(coursePostDTO.getScore() );
        }

        courseRepository.save(course);

        return MapperCourse.toDTO(course);
    }

    @Override
    public void deleteCourse(Long id) {

        courseRepository.findById(id)
                .orElseThrow(() -> new ErrorControllerApi(ErrorApi.NOT_EXITS_DATA));

        courseRepository.deleteById(id);

    }
}
