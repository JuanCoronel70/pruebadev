package com.juan.pruebadev.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "franquicias")
public class Franquicia {
    @Id
    private String id;               // Id generado por Mongo
    private String nombre;
    private List<Sucursal> sucursales;  // Lista de sucursales
}