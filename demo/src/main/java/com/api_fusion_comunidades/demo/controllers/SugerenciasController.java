package com.api_fusion_comunidades.demo.controllers;

import com.api_fusion_comunidades.demo.models.Fusion;
import com.api_fusion_comunidades.demo.models.ContextoComunidadesDTO;
import com.api_fusion_comunidades.demo.services.SugerenciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/sugerencias")
public class SugerenciasController {
  @Autowired
  private SugerenciasService sugerenciaService;

  @PostMapping
  public ResponseEntity<ContextoComunidadesDTO> sugerirFusiones(@RequestBody ContextoComunidadesDTO solicitud){
    ContextoComunidadesDTO comunidadesYFusiones = sugerenciaService.sugerirFusiones(solicitud.getComunidades(), solicitud.getFusiones());
    return ResponseEntity.ok(comunidadesYFusiones);
  }

}



