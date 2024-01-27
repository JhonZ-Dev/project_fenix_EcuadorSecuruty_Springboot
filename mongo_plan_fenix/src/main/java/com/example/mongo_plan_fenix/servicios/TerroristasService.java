package com.example.mongo_plan_fenix.servicios;


import com.example.mongo_plan_fenix.Colecciones.TerroristasColeccion;
import com.example.mongo_plan_fenix.repositorios.TerroristasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerroristasService {
    @Autowired
    private TerroristasRepositorio repositorio;
    private int generarNuevoId() {
        List<TerroristasColeccion> idTerroristas = repositorio.findAll(Sort.by(Sort.Direction.DESC, "id_terroristas"));

        if (!idTerroristas.isEmpty()) {
            return idTerroristas.get(0).getId_terroristas() + 1;
        } else {
            return 1; // Si no hay documentos, comenzar desde 1
        }
    }

    //metodo para guardar un terrorista
    public TerroristasColeccion guardar(TerroristasColeccion coleccion){
        coleccion.setId_terroristas(generarNuevoId());
        return repositorio.save(coleccion);
    }
    //listar
    public List<TerroristasColeccion> listar(){
        return repositorio.findAll();
    }
    //buscarPorId
    private TerroristasColeccion buscarPorId(Long id_terroristas){
        TerroristasColeccion usuariosMantenimientoColletion =
                this.repositorio.findById(Math.toIntExact(id_terroristas)).orElse(null);
        return usuariosMantenimientoColletion;
    }

    private TerroristasColeccion actualizarMongo(TerroristasColeccion existe,
                                                 TerroristasColeccion actualizad){
        if(existe !=null){
            existe.setNombre(actualizad.getNombre());
            existe.setApellido(actualizad.getApellido());
            existe.setEdad(actualizad.getEdad());
            existe.setFecha_nacimiento(actualizad.getFecha_nacimiento());
            existe.setDescripcion(actualizad.getDescripcion());
            existe.setNum_telefono_familiar(actualizad.getNum_telefono_familiar());
            existe.setGenero(actualizad.getGenero());
            return repositorio.save(existe);
        }else{
            throw new RuntimeException("No se encontró el terrorista con ID: " + actualizad.getId_terroristas());

        }
    }
    public TerroristasColeccion editar(TerroristasColeccion coleccion,
                                       Integer id_terroristas){
        TerroristasColeccion existe = buscarPorId(Long.valueOf(id_terroristas));
        return actualizarMongo(existe,coleccion);
    }

    public void eliminar(Integer id_terroristas){
        repositorio.deleteById(id_terroristas);
    }






}
