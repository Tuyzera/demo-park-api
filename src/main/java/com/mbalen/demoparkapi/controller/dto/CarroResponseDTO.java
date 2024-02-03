package com.mbalen.demoparkapi.controller.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarroResponseDTO {
    public Long id;
    public String nomeDoCarro;
    public long ano;
    public String marca;
    public String proprietario;
    public String modelo;
}
