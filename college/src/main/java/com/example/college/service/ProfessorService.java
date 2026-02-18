package com.example.college.service;

import com.example.college.dto.ProfessorDTO;
import com.example.college.service.interfacesServ.IProfessor;

import java.util.List;

public class ProfessorService implements IProfessor {
    @Override
    public List<ProfessorDTO> getProfessor() {
        return List.of();
    }

    @Override
    public ProfessorDTO postProfessor(ProfessorDTO professorDTO) {
        return null;
    }

    @Override
    public ProfessorDTO putProfessor(Long id, ProfessorDTO professorDTO) {
        return null;
    }

    @Override
    public void deleteProfessor(Long id) {

    }
}
