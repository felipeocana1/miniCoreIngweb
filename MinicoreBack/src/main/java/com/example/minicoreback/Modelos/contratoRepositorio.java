package com.example.minicoreback.Modelos;

import com.example.minicoreback.Entidades.Contrato;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface contratoRepositorio extends MongoRepository<Contrato,String> {
}
