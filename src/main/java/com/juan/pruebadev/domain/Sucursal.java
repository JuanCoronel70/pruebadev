package com.juan.pruebadev.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sucursal {
    private String id;           // Id único de la sucursal
    private String nombre;
    private List<Producto> productos;  // Lista de productos
}
