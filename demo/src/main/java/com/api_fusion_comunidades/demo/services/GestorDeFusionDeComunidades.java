package com.api_fusion_comunidades.demo.services;

import com.api_fusion_comunidades.demo.models.Comunidad;
import com.api_fusion_comunidades.demo.models.Config;
import com.api_fusion_comunidades.demo.models.Fusion;
import com.api_fusion_comunidades.demo.models.condicionesDeFusion.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class GestorDeFusionDeComunidades {
    private ArrayList<CondicionDeFusion> condicionesBasicasDeFusiones;

    public GestorDeFusionDeComunidades() {
        this.condicionesBasicasDeFusiones = new ArrayList<>();
        this.condicionesBasicasDeFusiones.add(new EstablecimientosObservados());
        this.condicionesBasicasDeFusiones.add(new ServiciosObservados());
        this.condicionesBasicasDeFusiones.add(new TienenMismoGradoDeConfianza());
        this.condicionesBasicasDeFusiones.add(new UsuariosEnComun());
    }

    public List<Fusion> sugerirFusion(List<Comunidad> comunidades, List<Fusion> fusiones) {
        List<Fusion> propuestas = new ArrayList<>();

        for(Comunidad comunidad1 : comunidades) {
            for (Comunidad comunidad2 : comunidades) {
                if (!Objects.equals(comunidad1.getId(), comunidad2.getId()) && this.cumpleCondicionesDeFusion(comunidad1, comunidad2, fusiones)) {
                    propuestas.add(crearPropuestaDeFusion(comunidad1, comunidad2));
                    comunidades.remove(comunidad1);
                    comunidades.remove(comunidad2);
                }
            }
        }
        return propuestas;
    }

    public Fusion crearPropuestaDeFusion(Comunidad comunidad1, Comunidad comunidad2) {
        return new Fusion(comunidad1, comunidad2);
    }

    public Boolean cumpleCondicionesDeFusion(Comunidad comunidad1, Comunidad comunidad2, List<Fusion> fusiones) {
        return this.cumpleTemporalidadExistentes(comunidad1, comunidad2, fusiones)
                && condicionesBasicasDeFusiones.stream().allMatch(condicionDeFusion ->
                    condicionDeFusion.cumpleCondicionDeFusion(comunidad1, comunidad2));
    }

    private Boolean cumpleTemporalidadExistentes (Comunidad comunidad1, Comunidad comunidad2, List<Fusion> fusiones) { //esto puede ser una condicionDeFusion mas
        Integer cantidadMesesDiferencia = Integer.parseInt(Config.obtenerInstancia().obtenerDelConfig("mesesDeDiferenciaEntrePropuestas"));
        List<Fusion> fusionesExistentes;
        fusionesExistentes = fusiones.stream().filter(fusion -> fusion.mismasComunidades(comunidad1, comunidad2)
                && LocalDateTime.now().getMonthValue() > fusion.getFechaCreada().getMonthValue() + cantidadMesesDiferencia).toList();
        return fusionesExistentes.size() > 0;
    }
}