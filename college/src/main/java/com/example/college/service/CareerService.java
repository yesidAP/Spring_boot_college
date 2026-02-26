package com.example.college.service;

import com.example.college.Enum.ErrorApi;
import com.example.college.dto.CareerDTO;
import com.example.college.exception.ErrorControllerApi;
import com.example.college.mapper.MapperCareer;
import com.example.college.model.Career;
import com.example.college.repository.CareerRepository;
import com.example.college.service.interfacesServ.ICareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for Career entity
 * @author yfandica
 */
@Service
public class CareerService implements ICareerService {

    @Autowired
    CareerRepository careerRepository;

    @Override
    public List<CareerDTO> getCareers() {

        return careerRepository.findAll().stream().map(MapperCareer::toDTO).toList();
    }

    @Override
    public CareerDTO postCareer(CareerDTO careerDTO) {

        if (MapperCareer.isEmpty(careerDTO)) throw new ErrorControllerApi(ErrorApi.INVALID_INPUT);

        //transform data in DTO format to entity format
        Career c = MapperCareer.toEntity(careerDTO);

        //Save the new element in the career entity
        careerRepository.save(c);

        //Show the new element in DTO format
        return MapperCareer.toDTO(c);
    }

    @Override
    public CareerDTO putCareer(Long id, CareerDTO careerDTO) {

        if (MapperCareer.isEmpty(careerDTO)) throw new ErrorControllerApi(ErrorApi.INVALID_INPUT);

        Career c = careerRepository.findById(id)
                .orElseThrow(() -> new ErrorControllerApi(ErrorApi.NOT_EXITS_DATA));

        if (careerDTO.getName() != null){
            c.setName(careerDTO.getName());
        }
        careerRepository.save(c);
        return MapperCareer.toDTO(c);

    }

    @Override
    public void deleteCareer(Long id) {

        careerRepository.findById(id)
                .orElseThrow(() -> new ErrorControllerApi(ErrorApi.NOT_EXITS_DATA));

        careerRepository.deleteById(id);

    }
}
