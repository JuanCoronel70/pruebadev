package com.juan.pruebadev.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    private String id;      // Puede ser generado por Mongo
    private String nombre;
    private int stock;
}