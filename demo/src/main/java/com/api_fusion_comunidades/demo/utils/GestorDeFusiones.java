package com.api_fusion_comunidades.demo.utils;

import com.api_fusion_comunidades.demo.models.Comunidad;
import com.api_fusion_comunidades.demo.models.PayloadDTO;
import com.api_fusion_comunidades.demo.models.Fusion;

import java.util.List;

public class GestorDeFusiones {
  public PayloadDTO ejecutarFusiones(List<Comunidad> comunidades, List<Fusion> fusiones) {
    List<Fusion> fusionesAceptadas = fusiones.stream().filter(x -> x.getEstado().equals(Fusion.EstadoFusion.ACEPTADA)).toList();
    List<Comunidad> nuevasComunidades = new Fusionador().ejecutar(comunidades, fusionesAceptadas);
    List<Fusion> fusionesPropuestas = fusiones.stream().filter(x -> x.getEstado().equals(Fusion.EstadoFusion.PROPUESTA)).toList();

    return new PayloadDTO(nuevasComunidades, fusionesPropuestas);
  }
}
