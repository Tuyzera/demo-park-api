package com.mbalen.demoparkapi.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
@Table(name = "LIVROS")
public class LivroUdi  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIVRO_SEQ")
    @SequenceGenerator(name = "LIVRO_SEQ", sequenceName = "LIVRO_SEQ", allocationSize = 1)
    @Column(name = "NR_SEQUENCIA")
    private BigDecimal sequence;

    @Column(name = "DS_TITULO")
    private String titulo;

    @Column(name = "DS_AUTOR")
    private String autor;

    @Column(name = "NM_ANO")
    private Long ano;

    @Column(name = "NR_PAGINAS")
    private int nr_paginas;

    @Column(name = "NR_CLASSIFICACAO")
    private Long nr_classifcacao;


    public BigDecimal getSequence() {
        return sequence;
    }

    public void setSequence(BigDecimal sequence) {
        this.sequence = sequence;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Long getAno() {
        return ano;
    }

    public void setAno(Long ano) {
        this.ano = ano;
    }

    public int getNr_paginas() {
        return nr_paginas;
    }

    public void setNr_paginas(int nr_paginas) {
        this.nr_paginas = nr_paginas;
    }

    public Long getNr_classifcacao() {
        return nr_classifcacao;
    }

    public void setNr_classifcacao(Long nr_classifcacao) {
        this.nr_classifcacao = nr_classifcacao;
    }
}
