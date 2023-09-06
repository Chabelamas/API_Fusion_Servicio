package com.api_fusion_comunidades.demo.models.condicionesDeFusion;


import com.api_fusion_comunidades.demo.models.Comunidad;

public interface CondicionDeFusion {
    Boolean cumpleCondicionDeFusion(Comunidad Comunidad1, Comunidad Comunidad2);
}
