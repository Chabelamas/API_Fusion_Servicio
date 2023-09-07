package com.api_fusion_comunidades.demo.controllers;

import com.api_fusion_comunidades.demo.models.Comunidad;
import com.api_fusion_comunidades.demo.models.Fusion;
import com.api_fusion_comunidades.demo.services.GestorDeFusionDeComunidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController @RequestMapping("/sugerencias")
public class SugerenciasController {
  @Autowired
  private GestorDeFusionDeComunidades sugerenciaService;

  @PostMapping
  public ResponseEntity<List<Fusion>> sugerirFusion(@RequestBody SolicitudDTO solicitud){
    List<Fusion> fusiones = sugerenciaService.sugerirFusion(solicitud.getComunidades(), solicitud.getFusiones());
    return ResponseEntity.ok(fusiones);
  }

}



