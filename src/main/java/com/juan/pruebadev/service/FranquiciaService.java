package com.juan.pruebadev.service;


import com.juan.pruebadev.domain.Franquicia;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FranquiciaService {

    Mono<Object> crearFranquicia(Franquicia franquicia);

    Flux<Franquicia> listarFranquicias();

    Mono<Franquicia> obtenerPorId(String id);

    Mono<Franquicia> obtenerPorNombre(String nombre); // útil para evitar duplicados o actualizar nombre
}
