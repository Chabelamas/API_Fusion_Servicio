package com.api_fusion_comunidades.demo.models.condicionesDeFusion;

import com.api_fusion_comunidades.demo.models.Comunidad;
import com.api_fusion_comunidades.demo.models.Config;
import com.api_fusion_comunidades.demo.services.Calculador;

public class UsuariosEnComun implements CondicionDeFusion {

    float porcentajeRequerido = Float.parseFloat(Config.obtenerInstancia().obtenerDelConfig("porcentajeEnComunUsuarios"));

    public Boolean cumpleCondicionDeFusion(Comunidad comunidad1, Comunidad comunidad2) {
        float porcentajeEnComun = Calculador.obtenerInstancia().calcularPorcentajeEnComun(comunidad1.getIdMiembros(), comunidad2.getIdMiembros());

        return porcentajeEnComun == porcentajeRequerido;
    }
}
