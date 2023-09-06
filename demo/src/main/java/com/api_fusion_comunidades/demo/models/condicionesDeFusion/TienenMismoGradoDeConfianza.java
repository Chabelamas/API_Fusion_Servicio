package com.api_fusion_comunidades.demo.models.condicionesDeFusion;

import com.api_fusion_comunidades.demo.models.Comunidad;


public class TienenMismoGradoDeConfianza implements CondicionDeFusion {
    public Boolean cumpleCondicionDeFusion(Comunidad comunidad1, Comunidad comunidad2) {
        return comunidad1.getGradoDeConfianza() == comunidad2.getGradoDeConfianza();
    }
}
