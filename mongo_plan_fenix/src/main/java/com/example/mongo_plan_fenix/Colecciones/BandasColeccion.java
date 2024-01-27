package com.example.mongo_plan_fenix.Colecciones;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Bandas")
@Data
public class BandasColeccion {

    @Id
    @Indexed(unique = true)
    private int id_banda;
    private String ciudad_detenido;
    private String nombre_banda;
    private Boolean tatuajes_referenciales;
    private String descripcion_tatuaje;
    //relacion de uno a muchos con terroristas
    @DBRef
    private List<TerroristasColeccion> id_terroristas;


}
