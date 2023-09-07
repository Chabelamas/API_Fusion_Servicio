package com.api_fusion_comunidades.demo.services;

import com.api_fusion_comunidades.demo.models.Comunidad;
import com.api_fusion_comunidades.demo.models.ContextoComunidadesDTO;
import com.api_fusion_comunidades.demo.models.Fusion;
import com.api_fusion_comunidades.demo.utils.GestorDeFusiones;
import com.api_fusion_comunidades.demo.utils.Sugeridor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SugerenciasService {

    private static final GestorDeFusiones gestorDeFusiones = new GestorDeFusiones();
    private static final Sugeridor sugeridor = new Sugeridor();

    public ContextoComunidadesDTO sugerirFusiones(List<Comunidad> comunidades, List<Fusion> fusiones) {
        ContextoComunidadesDTO contextoPostFusiones = gestorDeFusiones.ejecutarFusiones(comunidades, fusiones);

        return sugeridor.sugerirNuevasFusiones(contextoPostFusiones.getComunidades(), contextoPostFusiones.getFusiones());
    }
}