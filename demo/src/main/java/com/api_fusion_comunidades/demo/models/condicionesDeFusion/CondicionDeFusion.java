package com.api_fusion_comunidades.demo.models.condicionesDeFusion;


import com.api_fusion_comunidades.demo.models.Comunidad;

public interface CondicionDeFusion {
    Boolean cumpleCondicionDeFusion(Comunidad comunidad1, Comunidad comunidad2);
}
