package com.mbalen.demoparkapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "Carros")
public class Carro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "nomeCarro", nullable = false)
    private String nomeDoCarro;

    @Enumerated(EnumType.STRING)
    @Column(name = "modelo", nullable = false)
    private Modelo modelo;

    public enum Modelo{
        SUV, Picapes, Crossover, Minivan, Esportivo, Sedan;
    }

    @Column(name = "ano", nullable = false)
    private long ano;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "cor", nullable = false)
    private String cor;

    @Column(name = "preco", nullable = false)
    private long preco;

    @Column(name = "proprietario")
    private String proprietario;

    @Column(name = "proprietario_cpf")
    private String proprietario_cpf;



}
