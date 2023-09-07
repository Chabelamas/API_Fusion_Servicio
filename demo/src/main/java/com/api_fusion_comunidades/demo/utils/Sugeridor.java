package com.api_fusion_comunidades.demo.utils;

import com.api_fusion_comunidades.demo.models.Comunidad;
import com.api_fusion_comunidades.demo.models.PayloadDTO;
import com.api_fusion_comunidades.demo.models.Fusion;
import com.api_fusion_comunidades.demo.utils.condicionesDeFusion.*;

import java.util.*;

public class Sugeridor {
  private List<CondicionDeFusion> condicionesBasicasDeFusiones = new ArrayList<>();

  public Sugeridor() {
    this.condicionesBasicasDeFusiones.add(new EstablecimientosObservados());
    this.condicionesBasicasDeFusiones.add(new ServiciosObservados());
    this.condicionesBasicasDeFusiones.add(new TienenMismoGradoDeConfianza());
    this.condicionesBasicasDeFusiones.add(new UsuariosEnComun());
    this.condicionesBasicasDeFusiones.add(new NoSePropusoHacePoco());
  }

  public PayloadDTO sugerirNuevasFusiones(List<Comunidad> comunidades, List<Fusion> fusiones) {
    Set<Comunidad> comunidadesConNuevaPropuesta = new HashSet<>();

    for(Comunidad comunidad1 : comunidades) {
      for (Comunidad comunidad2 : comunidades) {
        if (this.sonComunidadesValidas(comunidad1, comunidad2, comunidadesConNuevaPropuesta)
            && this.cumpleCondicionesDeFusion(comunidad1, comunidad2, fusiones)) {
          fusiones.add(new Fusion(comunidad1, comunidad2));
          comunidadesConNuevaPropuesta.add(comunidad1);
          comunidadesConNuevaPropuesta.add(comunidad2);
        }
      }
    }

    return new PayloadDTO(comunidades, fusiones);
  }

  private boolean sonComunidadesValidas(Comunidad comunidad1, Comunidad comunidad2, Set<Comunidad> comunidadesConNuevaPropuesta) {
    return sonDistintasComunidades(comunidad1, comunidad2) && !comunidadesConNuevaPropuesta.contains(comunidad1) && !comunidadesConNuevaPropuesta.contains(comunidad2);
  }

  private boolean sonDistintasComunidades(Comunidad comunidad1, Comunidad comunidad2) {
    return !Objects.equals(comunidad1.getId(), comunidad2.getId());
  }

  public Boolean cumpleCondicionesDeFusion(Comunidad comunidad1, Comunidad comunidad2, List<Fusion> fusiones) {
    return condicionesBasicasDeFusiones.stream().allMatch(condicionDeFusion ->
        condicionDeFusion.cumpleCondicionDeFusion(comunidad1, comunidad2, fusiones));
  }
}
