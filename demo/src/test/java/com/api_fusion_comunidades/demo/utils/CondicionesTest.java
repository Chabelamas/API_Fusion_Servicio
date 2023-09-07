package com.api_fusion_comunidades.demo.utils;

import com.api_fusion_comunidades.demo.models.condicionesDeFusion.EstablecimientosObservados;
import com.api_fusion_comunidades.demo.models.condicionesDeFusion.ServiciosObservados;
import com.api_fusion_comunidades.demo.models.condicionesDeFusion.TienenMismoGradoDeConfianza;
import com.api_fusion_comunidades.demo.models.condicionesDeFusion.UsuariosEnComun;
import org.junit.jupiter.api.BeforeEach;
import com.api_fusion_comunidades.demo.models.Comunidad;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class CondicionesTest {
  private Comunidad comunidad1;
  private Comunidad comunidad2;

  @BeforeEach
  public void init() {
    List<Integer> i = new ArrayList<>();
    i.add(1);
    comunidad1 = new Comunidad(1, i,i, 1, i);
    comunidad2 = new Comunidad(2, i,i, 1, i);
  }

  @Test
  @DisplayName("Prueba que dos comunidades cumplan con el porcentaje correcto de establecimientos observados en común")
  public void establecimientosObservados(){
    EstablecimientosObservados establecimientosObservados = new EstablecimientosObservados();
    assertTrue(establecimientosObservados.cumpleCondicionDeFusion(comunidad1, comunidad2));
  }

  @Test
  @DisplayName("Prueba que dos comunidades cumplan con el porcentaje correcto de servicios observados en común")
  public void serviciosObservados(){
    ServiciosObservados serviciosObservados = new ServiciosObservados();
    assertTrue(serviciosObservados.cumpleCondicionDeFusion(comunidad1, comunidad2));
  }

  @Test
  @DisplayName("Prueba que dos comunidades tengan el mismo gradoDeConfianza")
  public void tienenMismoGradoDeConfianza(){
    TienenMismoGradoDeConfianza tienenMismoGradoDeConfianza = new TienenMismoGradoDeConfianza();
    assertTrue(tienenMismoGradoDeConfianza.cumpleCondicionDeFusion(comunidad1, comunidad2));
  }

  @Test
  @DisplayName("Prueba que dos comunidades cumplan con el porcentaje correcto de usuarios observados en común")
  public void usuariosEnComun(){
    UsuariosEnComun usuariosEnComun = new UsuariosEnComun();
    assertTrue(usuariosEnComun.cumpleCondicionDeFusion(comunidad1, comunidad2));
  }
}
