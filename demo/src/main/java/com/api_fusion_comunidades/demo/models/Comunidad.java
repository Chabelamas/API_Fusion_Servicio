package com.api_fusion_comunidades.demo.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Getter@Setter
public class Comunidad {

    private Integer id;
    private ArrayList<Integer> idEstablecimientoObservados = new ArrayList<>();
    private ArrayList<Integer> idServiciosObservados = new ArrayList<>();
    private int gradoDeConfianza;
    private ArrayList<Integer> idMiembros = new ArrayList<>();

}
