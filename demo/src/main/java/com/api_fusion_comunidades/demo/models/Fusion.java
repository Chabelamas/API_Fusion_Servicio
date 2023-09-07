package com.api_fusion_comunidades.demo.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
@Getter@Setter
public class Fusion {
    private Comunidad comunidad1;
    private Comunidad comunidad2;
    private LocalDateTime fechaCreada;

    public Fusion(Comunidad comunidad1, Comunidad comunidad2) {
        this.comunidad1 = comunidad1;
        this.comunidad2 = comunidad2;
        this.fechaCreada = LocalDateTime.now();
    }

    public Boolean mismasComunidades (Comunidad a, Comunidad b) {
        return (comunidad1.equals(a) && comunidad2.equals(b))||(comunidad1.equals(b) && comunidad2.equals(a));
    }

}



