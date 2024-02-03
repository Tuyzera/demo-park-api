package com.mbalen.demoparkapi.repository;

import com.mbalen.demoparkapi.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    List<Carro> findByAno(Long ano);

    List<Carro> findByMarca(String marca);
}