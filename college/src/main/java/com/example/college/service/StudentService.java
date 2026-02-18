package com.example.college.service;

import com.example.college.dto.StudentGetDTO;
import com.example.college.dto.StudentPostDTO;
import com.example.college.service.interfacesServ.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    @Override
    public List<StudentGetDTO> getStudent() {
        return List.of();
    }

    @Override
    public StudentPostDTO postStudent(StudentPostDTO studentPostDTO) {
        return null;
    }

    @Override
    public StudentPostDTO putStudent(Long id, StudentPostDTO studentPostDTO) {
        return null;
    }

    @Override
    public void deleteStudent(Long id) {

    }
}
