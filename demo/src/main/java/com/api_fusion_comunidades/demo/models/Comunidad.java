package com.api_fusion_comunidades.demo.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter@Setter
public class Comunidad {

    private Integer id;
    private Set<Integer> idEstablecimientoObservados;
    private Set<Integer> idServiciosObservados;
    private int gradoDeConfianza;
    private Set<Integer> idMiembros;

    public Comunidad(Integer id, Set<Integer> idEstablecimientoObservados, Set<Integer> idServiciosObservados, int gradoDeConfianza, Set<Integer> idMiembros) {
        this.id = id;
        this.idEstablecimientoObservados = idEstablecimientoObservados;
        this.idServiciosObservados = idServiciosObservados;
        this.gradoDeConfianza = gradoDeConfianza;
        this.idMiembros = idMiembros;
    }
}

