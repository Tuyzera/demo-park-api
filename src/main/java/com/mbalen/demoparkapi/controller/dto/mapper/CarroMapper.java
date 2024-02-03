package com.mbalen.demoparkapi.controller.dto.mapper;

import com.mbalen.demoparkapi.controller.dto.CarroResponseDTO;
import com.mbalen.demoparkapi.controller.dto.CarroResponseMarcasDTO;
import com.mbalen.demoparkapi.entity.Carro;
import org.modelmapper.ModelMapper;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

public class CarroMapper {

    public static CarroResponseMarcasDTO toMarcaDto(Carro carro){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(carro, CarroResponseMarcasDTO.class);
    }

    public static List<CarroResponseMarcasDTO> toMarcaDTOList(List<Carro> carros){
        return carros.stream().map(carro -> toMarcaDto(carro)).collect(Collectors.toList());
    }

    public static CarroResponseDTO toDto(Carro carro){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(carro, CarroResponseDTO.class);
    }

    public static List<CarroResponseDTO> toDtoList(List<Carro> carros){
        return carros.stream().map(carro -> toDto(carro)).collect(Collectors.toList());
    }


}
