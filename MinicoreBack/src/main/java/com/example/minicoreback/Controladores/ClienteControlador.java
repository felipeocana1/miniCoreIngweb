package com.example.minicoreback.Controladores;

import com.example.minicoreback.Entidades.Cliente;
import com.example.minicoreback.Modelos.clienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ClienteControlador {
    @Autowired
    private clienteRepositorio CLIR;


    public  Cliente agregarClientes(String nombre){
        return CLIR.save(new Cliente(nombre));
    }
}
