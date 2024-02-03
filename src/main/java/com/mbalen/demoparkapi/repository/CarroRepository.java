package com.mbalen.demoparkapi.repository;

import com.mbalen.demoparkapi.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}