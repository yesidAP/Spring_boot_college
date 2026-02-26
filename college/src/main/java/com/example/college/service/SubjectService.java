package com.example.college.service;

import com.example.college.Enum.ErrorApi;
import com.example.college.dto.SubjectGetDTO;
import com.example.college.dto.SubjectPostDTO;
import com.example.college.exception.ErrorControllerApi;
import com.example.college.mapper.MapperSubject;
import com.example.college.model.Professor;
import com.example.college.model.Subject;
import com.example.college.repository.ProfessorRepository;
import com.example.college.repository.SubjectRepository;
import com.example.college.service.interfacesServ.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for Subject entity
 * @author yfandica
 */
@Service
public class SubjectService implements ISubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    ProfessorRepository professorRepository;

    @Override
    public List<SubjectGetDTO> getSubjects() {
        return subjectRepository
                .findAll()
                .stream().map(MapperSubject::toDTO).toList();
    }

    @Override
    public SubjectGetDTO postSubject(SubjectPostDTO subjectPostDTO) {

        if (MapperSubject.isEmpty(subjectPostDTO)) throw new ErrorControllerApi(ErrorApi.INVALID_INPUT);

        Professor professor = professorRepository.findById(subjectPostDTO
                .getIdProfessor())
                .orElseThrow(() -> new ErrorControllerApi(ErrorApi.NOT_EXITS_DATA));

        Subject subject = MapperSubject.toEntity(subjectPostDTO);

        subject.setProfessor(professor);

        subjectRepository.save(subject);

        return MapperSubject.toDTO(subject);
    }

    @Override
    public SubjectGetDTO putSubject(Long id, SubjectPostDTO subjectPostDTO) {

        if (MapperSubject.isEmpty(subjectPostDTO)) throw new ErrorControllerApi(ErrorApi.INVALID_INPUT);

        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new ErrorControllerApi(ErrorApi.NOT_EXITS_DATA));

        if (subjectPostDTO.getName() != null){

            subject.setName(subjectPostDTO.getName());
        }
        if (subjectPostDTO.getCredits() != null){
            subject.setCredits(subjectPostDTO.getCredits());
        }
        if (subjectPostDTO.getIdProfessor() != null){
            Professor professor = professorRepository.findById(subjectPostDTO.getIdProfessor())
                    .orElseThrow(() -> new ErrorControllerApi(ErrorApi.NOT_EXITS_DATA));

            subject.setProfessor(professor);
        }

        subjectRepository.save(subject);

        return MapperSubject.toDTO(subject);
    }

    @Override
    public void deleteSubject(Long id) {

        subjectRepository.findById(id).orElseThrow(() -> new ErrorControllerApi(ErrorApi.NOT_EXITS_DATA));

        subjectRepository.deleteById(id);

    }
}
