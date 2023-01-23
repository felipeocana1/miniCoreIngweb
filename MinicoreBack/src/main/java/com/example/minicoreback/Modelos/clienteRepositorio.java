package com.example.minicoreback.Modelos;

import com.example.minicoreback.Entidades.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface clienteRepositorio extends MongoRepository<Cliente,String> {
}
