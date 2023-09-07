package com.api_fusion_comunidades.demo.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter
public class Comunidad {

    private Integer id;
    private List<Integer> idEstablecimientoObservados;
    private List<Integer> idServiciosObservados;
    private int gradoDeConfianza;
    private List<Integer> idMiembros;

    public Comunidad(Integer id, List<Integer> idEstablecimientoObservados, List<Integer> idServiciosObservados, int gradoDeConfianza, List<Integer> idMiembros) {
        this.id = id;
        this.idEstablecimientoObservados = idEstablecimientoObservados;
        this.idServiciosObservados = idServiciosObservados;
        this.gradoDeConfianza = gradoDeConfianza;
        this.idMiembros = idMiembros;
    }
}

