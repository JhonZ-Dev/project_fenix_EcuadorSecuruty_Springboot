package com.example.mongo_plan_fenix.Colecciones;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Document(collection = "Terroristas")
@Data
public class TerroristasColeccion {
    @Id
    @Indexed(unique=true)
    private int id_terroristas;
    private String nombre;
    private String apellido;
    private LocalDate fecha_nacimiento;
    private String descripcion;
    private String num_telefono_familiar;

}
