package com.example.minicoreback.Entidades;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection =  "Cliente")
@Getter
@Setter
public class Cliente {
    @Id
    private String id;
    private String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }
}
