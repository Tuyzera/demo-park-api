package com.mbalen.demoparkapi.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.sql.Time;
import java.util.TimeZone;

@Configuration
public class SpringTimeZoneConfig {

    @PostConstruct //Metodo construtor é executado quando projeto é inicializado
    public void timeZoneConfig(){
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
    }

}
