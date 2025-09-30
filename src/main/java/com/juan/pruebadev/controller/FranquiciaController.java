package com.juan.pruebadev.controller;

import com.juan.pruebadev.domain.Franquicia;
import com.juan.pruebadev.service.FranquiciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/franquicias")
public class FranquiciaController {

    private final FranquiciaService franquiciaService;

    public FranquiciaController(FranquiciaService franquiciaService) {
        this.franquiciaService = franquiciaService;
    }

    // POST /franquicias -> crear franquicia
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Object> crearFranquicia(@RequestBody Franquicia franquicia) {
        return franquiciaService.crearFranquicia(franquicia);
    }

    // GET /franquicias -> listar todas las franquicias
    @GetMapping
    public Flux<Franquicia> listarFranquicias() {
        return franquiciaService.listarFranquicias();
    }

    // GET /franquicias/{id} -> obtener franquicia por id
    @GetMapping("/{id}")
    public Mono<ResponseEntity<Franquicia>> obtenerFranquicia(@PathVariable String id) {
        return franquiciaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
