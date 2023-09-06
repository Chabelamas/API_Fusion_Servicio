package com.api_fusion_comunidades.demo.controllers;

import com.api_fusion_comunidades.demo.models.Comunidad;
import com.api_fusion_comunidades.demo.models.Fusion;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter @Getter
public class SolicitudDTO {
  private List<Comunidad> comunidades;
  private List<Fusion> fusiones;
}