package com.example.college.service;

import com.example.college.dto.CareerDTO;
import com.example.college.service.interfacesServ.ICareerService;

import java.util.List;

public class CareerService implements ICareerService {
    @Override
    public List<CareerDTO> getCareers() {
        return List.of();
    }

    @Override
    public CareerDTO postCareer(CareerDTO careerDTO) {
        return null;
    }

    @Override
    public CareerDTO putCareer(Long id, CareerDTO careerDTO) {
        return null;
    }

    @Override
    public void deleteCareer(Long id) {

    }
}
