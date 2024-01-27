package com.example.mongo_plan_fenix.repositorios;

import com.example.mongo_plan_fenix.Colecciones.TerroristasColeccion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface TerroristasRepositorio extends MongoRepository<TerroristasColeccion, Integer>

{
    @Query(value = "{}", sort = "{id_terroristas: -1}")
    Optional<TerroristasColeccion> findTopByOrderByIdTerroristasDesc();

}
