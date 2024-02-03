package com.mbalen.demoparkapi.controller;

import com.mbalen.demoparkapi.service.CarroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/carros")
public class CarroController {
    private final CarroService service;

}
