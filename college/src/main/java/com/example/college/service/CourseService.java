package com.example.college.service;

import com.example.college.dto.CourseGetDTO;
import com.example.college.dto.CoursePostDTO;
import com.example.college.exception.NotDataFound;
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

        Student student;
        Subject subject;
        List<CourseGetDTO> listCourse = courseRepository
                .findAll()
                .stream()
                .map(MapperCourse::toDTO)
                .toList();

        for(CourseGetDTO c: listCourse){
            student = studentRepository.findById(c.getIdStudent()).orElseThrow(NotDataFound::new);
            subject = subjectRepository.findById(c.getIdSubject()).orElseThrow(NotDataFound::new);

            c.setFullNameStudent(student.getName() + " " + student.getLastName());

            c.setNameSubject(subject.getName());

        }

        return listCourse;
    }

    @Override
    public CourseGetDTO postCourse(CoursePostDTO coursePostDTO) {

        Course course = MapperCourse.toEntity(coursePostDTO);

        Student student = studentRepository
                .findById(coursePostDTO.getIdStudent())
                .orElseThrow(NotDataFound::new);

        Subject subject = subjectRepository
                .findById(coursePostDTO.getIdSubject())
                .orElseThrow(NotDataFound::new);

        course.setStudent(student);
        course.setSubject(subject);

        courseRepository.save(course);

        return MapperCourse.toDTO(course);
    }

    @Override
    public CourseGetDTO putCourse(Long id, CoursePostDTO coursePostDTO) {

        Course course = courseRepository.findById(id)
                .orElseThrow(NotDataFound::new);

        if (coursePostDTO.getScore() != null ){
            course.setScore(coursePostDTO.getScore() );
        }

        courseRepository.save(course);

        return MapperCourse.toDTO(course);
    }

    @Override
    public void deleteCourse(Long id) {

        courseRepository.findById(id)
                .orElseThrow(NotDataFound::new);

        courseRepository.deleteById(id);

    }
}
