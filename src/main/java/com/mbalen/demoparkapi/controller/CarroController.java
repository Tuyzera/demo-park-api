package com.mbalen.demoparkapi.controller;

import com.mbalen.demoparkapi.controller.dto.CarroResponseDTO;
import com.mbalen.demoparkapi.controller.dto.mapper.CarroMapper;
import com.mbalen.demoparkapi.controller.dto.CarroResponseMarcasDTO;
import com.mbalen.demoparkapi.entity.Carro;
import com.mbalen.demoparkapi.service.CarroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/carros")
public class CarroController {
    private final CarroService service;

    @PostMapping
    public ResponseEntity<Carro> create(@RequestBody Carro carro){
        Carro car = this.service.createNewCar(carro);
        return ResponseEntity.status(HttpStatus.CREATED).body(car);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> getByID(@PathVariable Long id) throws Exception {
        Carro car = this.service.getByID(id);
        return ResponseEntity.ok(car);
    }

    @GetMapping("/ano/{ano}")
    public ResponseEntity<List<Carro>> getByYear(@PathVariable Long ano){
        List<Carro> car = this.service.getByYear(ano);
        return ResponseEntity.ok(car);
    }

    @GetMapping("/marca/{marca}")
    public ResponseEntity<List<Carro>> getByMarca(@PathVariable String marca){
        List<Carro> car = this.service.getByMarca(marca);
        return ResponseEntity.ok(car);
    }

    @GetMapping("/marcas")
    public ResponseEntity<List<CarroResponseMarcasDTO>> getAllMarcas(){
        List<Carro> cars = this.service.getAllMarcas();
        return ResponseEntity.ok(CarroMapper.toMarcaDTOList(cars));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CarroResponseDTO>> getAllCarros(){
        List<Carro> cars = this.service.getAllCarros();
        return ResponseEntity.ok(CarroMapper.toDtoList(cars));
    }

}
