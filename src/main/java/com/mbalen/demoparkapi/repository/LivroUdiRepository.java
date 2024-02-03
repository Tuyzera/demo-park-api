package com.mbalen.demoparkapi.repository;

import com.mbalen.demoparkapi.entity.LivroUdi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface LivroUdiRepository extends JpaRepository<LivroUdi, BigDecimal> {
}