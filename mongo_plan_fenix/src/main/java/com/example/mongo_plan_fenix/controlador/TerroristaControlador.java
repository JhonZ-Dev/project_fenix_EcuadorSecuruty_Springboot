package com.example.mongo_plan_fenix.controlador;

import com.example.mongo_plan_fenix.Colecciones.TerroristasColeccion;
import com.example.mongo_plan_fenix.servicios.TerroristasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/terroristas")
public class TerroristaControlador {

    @Autowired
    private TerroristasService service;

    //metodo para guardar
    @PostMapping("/guardar")
    public TerroristasColeccion guardar(@RequestBody TerroristasColeccion coleccion){
        return service.guardar(coleccion);
    }

    @PutMapping("/editar/{id_terroristas}")
    public TerroristasColeccion editar(@RequestBody TerroristasColeccion coleccion,
                                       @PathVariable Integer id_terroristas){
        return service.editar(coleccion, id_terroristas);
    }
    @GetMapping("/listar")
    public List<TerroristasColeccion> listar(){
        return service.listar();
    }

    @GetMapping("/listar/{id_terroristas}")
    public Optional<TerroristasColeccion> encontrarPorId(@PathVariable Integer id_terroristas){
        return service.traerPorId(id_terroristas);
    }

    @DeleteMapping("/eliminar/{id_terroristas}")
    public void eliminar(@PathVariable Integer id_terroristas){
        service.eliminar(id_terroristas);
    }
}
