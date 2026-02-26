package com.example.college.service;

import com.example.college.Enum.ErrorApi;
import com.example.college.dto.ProfessorDTO;
import com.example.college.exception.ErrorControllerApi;
import com.example.college.mapper.MapperProfessor;
import com.example.college.model.Professor;
import com.example.college.repository.ProfessorRepository;
import com.example.college.service.interfacesServ.IProfessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for Professor entity
 * @author yfandica
 */
@Service
public class ProfessorService implements IProfessor {

    @Autowired
    ProfessorRepository professorRepository;
    @Override
    public List<ProfessorDTO> getProfessor() {

        return professorRepository.findAll().stream().map(MapperProfessor::toDTO).toList();
    }

    @Override
    public ProfessorDTO postProfessor(ProfessorDTO professorDTO) {

        if (MapperProfessor.isEmpty(professorDTO)) throw new ErrorControllerApi(ErrorApi.INVALID_INPUT);

        Professor professor = MapperProfessor.toEntity(professorDTO);

        professorRepository.save(professor);

        return MapperProfessor.toDTO(professor);
    }

    @Override
    public ProfessorDTO putProfessor(Long id, ProfessorDTO professorDTO) {

        if (MapperProfessor.isEmpty(professorDTO)) throw new ErrorControllerApi(ErrorApi.INVALID_INPUT);

        Professor professor = professorRepository
                .findById(id)
                .orElseThrow(() -> new ErrorControllerApi(ErrorApi.NOT_EXITS_DATA));

        if(professorDTO.getName() != null){
            professor.setName(professorDTO.getName());
        }
        if(professorDTO.getLastName() != null){
            professor.setLastName(professorDTO.getLastName());
        }
        if(professorDTO.getAge() != null){
            professor.setAge(professorDTO.getAge());
        }
        if(professorDTO.getEntryDate() != null){
            professor.setEntryDate(professorDTO.getEntryDate());
        }

        professorRepository.save(professor);
        return MapperProfessor.toDTO(professor);
    }

    @Override
    public void deleteProfessor(Long id) {

        professorRepository
                .findById(id)
                .orElseThrow(() -> new ErrorControllerApi(ErrorApi.NOT_EXITS_DATA));

        professorRepository.deleteById(id);

    }
}
