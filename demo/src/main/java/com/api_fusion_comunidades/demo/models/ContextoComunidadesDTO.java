package com.api_fusion_comunidades.demo.models;

import lombok.Getter;

import java.util.List;

@Getter
public class ContextoComunidadesDTO {
  private List<Comunidad> comunidades;
  private List<Fusion> fusiones;

  public ContextoComunidadesDTO(List<Comunidad> comunidades, List<Fusion> fusiones) {
    this.comunidades = comunidades;
    this.fusiones = fusiones;
  }
}