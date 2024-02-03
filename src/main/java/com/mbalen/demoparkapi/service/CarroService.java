package com.mbalen.demoparkapi.service;

import com.mbalen.demoparkapi.entity.Carro;
import com.mbalen.demoparkapi.repository.CarroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor //Criar um metodo construtor com a variavel usuario repository
@Service
public class CarroService {
    private final CarroRepository repository;
    @Transactional
    public Carro createNewCar(Carro carro) {
        return this.repository.save(carro);
    }
    @Transactional(readOnly = true)
    public Carro getByID(Long id) throws Exception {
        return this.repository.findById(id).orElseThrow(
                () -> new Exception("Usuario não encontrado ou Aconteceu algum outro problema!")
        );
    }

    public List<Carro> getByYear(Long ano) {
        return this.repository.findByAno(ano);
    }

    public List<Carro> getByMarca(String marca) {
        return this.repository.findByMarca(marca);
    }

    public List<Carro> getAllMarcas() {
        return this.repository.findAll();
    }

    public List<Carro> getAllCarros() {
        return this.repository.findAll();
    }
}
