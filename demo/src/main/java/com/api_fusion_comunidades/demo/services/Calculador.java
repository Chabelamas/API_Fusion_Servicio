package com.api_fusion_comunidades.demo.services;

import java.util.List;

public class Calculador {
    private static Calculador instancia;

    private Calculador() {
    }

    public static Calculador obtenerInstancia() { // Singleton
        if (instancia == null){
            instancia = new Calculador();
        }
        return instancia;
    }

    public float calcularPorcentajeEnComun(List<Integer> lista1, List<Integer> lista2) {
        float cantidadDeElementosTotal = (float) Math.min(lista1.size(), lista2.size());
        float elementosEnComun = 0F;

        for(float elemento1 : lista1) {
            for(float elemento2 : lista2) {
                if(elemento1 == elemento2) {
                    elementosEnComun++;
                }
            }
        }
        return (elementosEnComun/cantidadDeElementosTotal);
    }
}
