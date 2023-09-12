package com.api_fusion_comunidades.demo.utils;

import com.api_fusion_comunidades.demo.models.Comunidad;
import com.api_fusion_comunidades.demo.models.Fusion;

import java.util.*;

public class Fusionador {

  public List<Comunidad> ejecutar(List<Comunidad> comunidades, List<Fusion> fusiones) {
    for(Fusion fusion : fusiones) {
      Comunidad nuevaComunidad = this.crearComunidadFusionada(fusion.getComunidad1(), fusion.getComunidad2());

      eliminarComunidadPorId(comunidades, fusion.getComunidad1().getId());
      eliminarComunidadPorId(comunidades, fusion.getComunidad2().getId());
      comunidades.add(nuevaComunidad);
    }

    return comunidades;
  }

  private void eliminarComunidadPorId(List<Comunidad> comunidades, Integer id) {
    for (Comunidad comunidad : comunidades) {
      if (Objects.equals(comunidad.getId(), id)) {
        comunidades.remove(comunidad);
        break;
      }
    }
  }

  public Comunidad crearComunidadFusionada (Comunidad comunidad1, Comunidad comunidad2) {
    Set<Integer> nuevosEstablecimientosObservados = new HashSet<>();
    nuevosEstablecimientosObservados.addAll(comunidad1.getIdEstablecimientoObservados());
    nuevosEstablecimientosObservados.addAll(comunidad2.getIdEstablecimientoObservados());

    Set<Integer> nuevosServiciosObservados = new HashSet<>();
    nuevosServiciosObservados.addAll(comunidad1.getIdServiciosObservados());
    nuevosServiciosObservados.addAll(comunidad2.getIdServiciosObservados());

    Set<Integer> nuevosMiembros = new HashSet<>();
    nuevosMiembros.addAll(comunidad1.getIdMiembros());
    nuevosMiembros.addAll(comunidad2.getIdMiembros());

    return new Comunidad(0, nuevosEstablecimientosObservados.stream().toList(), nuevosServiciosObservados.stream().toList(), 0, nuevosMiembros.stream().toList());
  }

}
