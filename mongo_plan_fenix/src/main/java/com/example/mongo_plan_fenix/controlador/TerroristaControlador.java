package com.example.mongo_plan_fenix.controlador;

import com.example.mongo_plan_fenix.Colecciones.TerroristasColeccion;
import com.example.mongo_plan_fenix.servicios.TerroristasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/terroristas")
public class TerroristaControlador {

    @Autowired
    private TerroristasService service;

    //metodo para guardar
    public TerroristasColeccion guardar(@RequestBody TerroristasColeccion coleccion){
        return service.guardar(coleccion);
    }
}
