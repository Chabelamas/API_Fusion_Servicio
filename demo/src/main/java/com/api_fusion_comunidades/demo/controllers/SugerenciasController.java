package com.api_fusion_comunidades.demo.controllers;

import com.api_fusion_comunidades.demo.models.Comunidad;
import com.api_fusion_comunidades.demo.models.Fusion;
import com.api_fusion_comunidades.demo.services.GestorDeFusionDeComunidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequestMapping("/sugerencias")
public class SugerenciasController {
  @Autowired
  private GestorDeFusionDeComunidades gestor;

  @GetMapping
  public ResponseEntity<List<Fusion>> sugerirFusion(@RequestBody SolicitudDTO solicitud){

    return ResponseEntity.ok(gestor.sugerirFusion(solicitud.getComunidades(), solicitud.getFusiones()));
  }

}
