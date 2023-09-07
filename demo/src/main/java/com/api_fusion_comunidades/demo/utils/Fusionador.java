package com.api_fusion_comunidades.demo.utils;

import com.api_fusion_comunidades.demo.models.Comunidad;
import com.api_fusion_comunidades.demo.models.Fusion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Fusionador {

  public List<Comunidad> ejecutar(List<Comunidad> comunidades, List<Fusion> fusiones) {
    for(Fusion fusion : fusiones) {
      Comunidad nuevaComunidad = this.crearComunidadFusionada(fusion.getComunidad1(), fusion.getComunidad2());
      comunidades.add(nuevaComunidad);
      comunidades.remove(fusion.getComunidad1());
      comunidades.remove(fusion.getComunidad2());
    }

    return comunidades;
  }



  private Comunidad crearComunidadFusionada (Comunidad comunidad1, Comunidad comunidad2) {
    Set<Integer> nuevosEstablecimientosObservados = new HashSet<>();
    nuevosEstablecimientosObservados.addAll(comunidad1.getIdEstablecimientoObservados());
    nuevosEstablecimientosObservados.addAll(comunidad2.getIdEstablecimientoObservados());

    Set<Integer> nuevosServiciosObservados = new HashSet<>();
    nuevosServiciosObservados.addAll(comunidad1.getIdServiciosObservados());
    nuevosServiciosObservados.addAll(comunidad2.getIdServiciosObservados());

    Set<Integer> nuevosMiembros = new HashSet<>();
    nuevosMiembros.addAll(comunidad1.getIdMiembros());
    nuevosMiembros.addAll(comunidad2.getIdMiembros());

    return new Comunidad(comunidad1.getId(), nuevosEstablecimientosObservados, nuevosServiciosObservados, 0, nuevosMiembros);
  }

}
