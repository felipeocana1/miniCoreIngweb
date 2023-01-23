package com.example.minicoreback.PuntosFinales;

import com.example.minicoreback.Controladores.ClienteControlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/Cliente")
public class Cliente {

    @Autowired
    private ClienteControlador CLICON;

    @PostMapping(path = "/crear")
    public ResponseEntity<?> crearCliente(){
        try{
            com.example.minicoreback.Entidades.Cliente cl1= CLICON.agregarClientes("UDLA");
            return new ResponseEntity<Cliente>((MultiValueMap<String, String>) cl1, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_GATEWAY);
        }
    }


}
