package com.example.mongo_plan_fenix.servicios;

import com.example.mongo_plan_fenix.Colecciones.BandasColeccion;
import com.example.mongo_plan_fenix.Colecciones.TerroristasColeccion;
import com.example.mongo_plan_fenix.repositorios.BandaRepositorio;
import com.example.mongo_plan_fenix.repositorios.TerroristasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BandasServices {

    @Autowired
    private BandaRepositorio repositorio;
    @Autowired
    private TerroristasRepositorio terroristasRepositorio;
    private int generarNuevoId() {
        List<BandasColeccion> bandas = repositorio.findAll(Sort.by(Sort.Direction.DESC, "id_banda"));

        if (!bandas.isEmpty()) {
            return bandas.get(0).getId_banda() + 1;
        } else {
            return 1; // Si no hay documentos, comenzar desde 1
        }
    }

    //guardar con un terrorista
    public BandasColeccion guardarConTerrorista(BandasColeccion coleccion,
                                                Integer id_terroristas)
    {
        //generar un nuevo id para banda
        coleccion.setId_banda(generarNuevoId());
        //buscar el terroriste
        Optional<TerroristasColeccion>optionalTerroristasColeccion= terroristasRepositorio.findById(id_terroristas);

        //verificar si el terrorista existe
        if(optionalTerroristasColeccion.isPresent()){
            TerroristasColeccion terroristasColeccion = optionalTerroristasColeccion.get();
            //asignar
            coleccion.setId_terroristas(Collections.singletonList(terroristasColeccion));
            //guarda
            return repositorio.save(coleccion);
        }else {
            throw new RuntimeException("Terrorista con id " + id_terroristas + " no encontrado.");
        }
    }
    public BandasColeccion buscarPorId(Integer id_banda){
        BandasColeccion costos = this.repositorio.findById(id_banda).orElse(null);
        return costos;
    }

    //editar
    public BandasColeccion editar(BandasColeccion bandasColeccion, Integer id_banda)
    {
        BandasColeccion existe = buscarPorId(id_banda);
        if(existe !=null){
            existe.setCiudad_detenido(bandasColeccion.getCiudad_detenido());
            existe.setNombre_banda(bandasColeccion.getNombre_banda());
            existe.setTatuajes_referenciales(bandasColeccion.getTatuajes_referenciales());
            existe.setDescripcion_tatuaje(bandasColeccion.getDescripcion_tatuaje());
            return repositorio.save(existe);
        }else{
            throw new RuntimeException("No se encontró la banda con ID: " + id_banda);
        }
    }

    //listar
    public List<BandasColeccion> listar(){
        return repositorio.findAll();
    }
    //traerPorId
    public Optional<BandasColeccion> traerPorId(Integer id_banda)
    {
        return repositorio.findById(id_banda);
    }

    //eliminar
    public void eliminar(Integer id_banda){
        repositorio.deleteById(id_banda);
    }
}
