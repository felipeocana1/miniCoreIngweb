package com.example.minicoreback.Entidades;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection =  "Contrato")
@Getter
@Setter
@RequiredArgsConstructor
public class Contrato {
    @Id
    private String id;
    private String nombre;
    private float monto;
    private Date fecha;
    private String clienteID;

    public Contrato(String nombre, float monto, Date fecha, String clienteID) {
        this.nombre = nombre;
        this.monto = monto;
        this.fecha = fecha;
        this.clienteID = clienteID;
    }
}
