package com.example.mongo_plan_fenix.controlador;

import com.example.mongo_plan_fenix.Colecciones.BandasColeccion;
import com.example.mongo_plan_fenix.Colecciones.TerroristasColeccion;
import com.example.mongo_plan_fenix.servicios.BandasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bandas")
public class BandasControlador {
    @Autowired
    private BandasServices services;

    @PostMapping("/guardar/{id_terroristas}")
    public BandasColeccion guardarConTerrorista(@RequestBody BandasColeccion coleccion,
                                                @PathVariable Integer id_terroristas)
    {
        return services.guardarConTerrorista(coleccion,id_terroristas);
    }
    @PutMapping("/editar/{id_banda}")
    public BandasColeccion editar(@RequestBody BandasColeccion bandasColeccion,
                                  @PathVariable Integer id_banda)
    {
        return services.editar(bandasColeccion, id_banda);
    }

    //listar

    @GetMapping("/listar")
    public List<BandasColeccion> listar(){
        return services.listar();
    }
    //traerPorId
    @GetMapping("/traer-por-id/{id_banda}")
    public Optional<BandasColeccion> traerPorId(@PathVariable Integer id_banda)
    {
        return services.traerPorId(id_banda);
    }

    //eliminar
    @DeleteMapping("/eliminar/{id_banda}")
    public void eliminar(@PathVariable Integer id_banda){
        services.eliminar(id_banda);
    }


}
