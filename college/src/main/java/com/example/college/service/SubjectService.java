package com.example.college.service;

import com.example.college.dto.SubjectGetDTO;
import com.example.college.dto.SubjectPostDTO;
import com.example.college.service.interfacesServ.ISubjectService;

import java.util.List;

public class SubjectService implements ISubjectService {
    @Override
    public List<SubjectGetDTO> getSubjects() {
        return List.of();
    }

    @Override
    public SubjectPostDTO postSubject(SubjectPostDTO subjectPostDTO) {
        return null;
    }

    @Override
    public SubjectPostDTO putSubject(Long id, SubjectPostDTO SubjectPostDTO) {
        return null;
    }

    @Override
    public void deleteSubject(Long id) {

    }
}
