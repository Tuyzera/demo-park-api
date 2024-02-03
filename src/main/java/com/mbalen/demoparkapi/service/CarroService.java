package com.mbalen.demoparkapi.service;

import com.mbalen.demoparkapi.repository.CarroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor //Criar um metodo construtor com a variavel usuario repository
@Service
public class CarroService {
    private final CarroRepository repository;
}
