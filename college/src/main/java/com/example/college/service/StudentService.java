package com.example.college.service;

import com.example.college.Enum.ErrorApi;
import com.example.college.dto.StudentGetDTO;
import com.example.college.dto.StudentPostDTO;
import com.example.college.exception.ErrorControllerApi;
import com.example.college.mapper.MapperStudent;
import com.example.college.model.Career;
import com.example.college.model.Student;
import com.example.college.repository.CareerRepository;
import com.example.college.repository.StudentRepository;
import com.example.college.service.interfacesServ.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for Student entity
 * @author yfandica
 */
@Service
public class StudentService implements IStudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CareerRepository careerRepository;
    @Override
    public List<StudentGetDTO> getStudent() {
        return studentRepository.findAll().stream().map(MapperStudent::toDTO).toList();
    }

    @Override
    public StudentGetDTO postStudent(StudentPostDTO studentPostDTO) {

        if (MapperStudent.isEmpty(studentPostDTO)) throw new ErrorControllerApi(ErrorApi.INVALID_INPUT);

        Career career = careerRepository.findById(studentPostDTO.getIdCareer())
                .orElseThrow(() -> new ErrorControllerApi(ErrorApi.NOT_EXITS_DATA));

        System.out.println(studentPostDTO.getLastName());
        Student student = MapperStudent.toEntity(studentPostDTO);
        System.out.println(student.getLastName());
        student.setCareer(career);

        studentRepository.save(student);

        return MapperStudent.toDTO(student);
    }

    @Override
    public StudentGetDTO putStudent(Long id, StudentPostDTO studentPostDTO) {

        if (MapperStudent.isEmpty(studentPostDTO)) throw new ErrorControllerApi(ErrorApi.INVALID_INPUT);

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ErrorControllerApi(ErrorApi.NOT_EXITS_DATA));

        if (studentPostDTO.getName() != null){
            student.setName(studentPostDTO.getName());
        }
        if (studentPostDTO.getLastName() != null){
            student.setLastName(studentPostDTO.getLastName());
        }
        if (studentPostDTO.getAge() != null){
            student.setAge(studentPostDTO.getAge());
        }
        if (studentPostDTO.getGender() != null){
            student.setGender(studentPostDTO.getGender());
        }
        if (studentPostDTO.getEntryDate() != null){
            student.setEntryDate(studentPostDTO.getEntryDate());
        }
        if (studentPostDTO.getIdCareer()!= null){

            Career c = careerRepository
                    .findById(studentPostDTO.getIdCareer())
                    .orElseThrow(() -> new ErrorControllerApi(ErrorApi.NOT_EXITS_DATA));

            student.setCareer(c);

        }

        studentRepository.save(student);

        return MapperStudent.toDTO(student);
    }

    @Override
    public void deleteStudent(Long id) {

        studentRepository
                .findById(id)
                .orElseThrow(() -> new ErrorControllerApi(ErrorApi.NOT_EXITS_DATA));

        studentRepository.deleteById(id);

    }
}
