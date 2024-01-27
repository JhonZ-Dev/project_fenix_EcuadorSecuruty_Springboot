package com.example.mongo_plan_fenix.repositorios;

import com.example.mongo_plan_fenix.Colecciones.BandasColeccion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface BandaRepositorio extends MongoRepository<BandasColeccion, Integer> {
    @Query(value = "{}", sort = "{id_banda: -1}")
    Optional<BandasColeccion> findTopByOrderByIdBandaDesc();
}
