package com.juan.pruebadev.repository;

import com.juan.pruebadev.domain.Franquicia;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface FranquiciaRepository extends ReactiveMongoRepository<Franquicia, String> {

    // Método extra para buscar por nombre
    Mono<Franquicia> findByNombre(String nombre);
}
