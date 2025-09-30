package com.juan.pruebadev.service;


import com.juan.pruebadev.domain.Franquicia;
import com.juan.pruebadev.repository.FranquiciaRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FranquiciaServiceImpl implements FranquiciaService {

    private final FranquiciaRepository franquiciaRepository;

    public FranquiciaServiceImpl(FranquiciaRepository franquiciaRepository) {
        this.franquiciaRepository = franquiciaRepository;
    }

    @Override
    public Mono<Object> crearFranquicia(Franquicia franquicia) {
        // Validación: evitar franquicias con el mismo nombre
        return franquiciaRepository.findByNombre(franquicia.getNombre())
                .flatMap(existing -> Mono.error(new RuntimeException("Franquicia ya existe")))
                .switchIfEmpty(franquiciaRepository.save(franquicia));
    }

    @Override
    public Flux<Franquicia> listarFranquicias() {
        return franquiciaRepository.findAll();
    }

    @Override
    public Mono<Franquicia> obtenerPorId(String id) {
        return franquiciaRepository.findById(id);
    }

    @Override
    public Mono<Franquicia> obtenerPorNombre(String nombre) {
        return franquiciaRepository.findByNombre(nombre);
    }
}
