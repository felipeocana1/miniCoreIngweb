package com.example.minicoreback.PuntosFinales;

import com.example.minicoreback.Controladores.ClienteControlador;
import com.example.minicoreback.Controladores.minicoreContro;
import com.example.minicoreback.Entidades.bodyReporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/minicore")
public class Minicore {

    @Autowired
    private ClienteControlador CLICON;

    @Autowired
    private minicoreContro MINCON;

    @GetMapping("/semilla")
    public ResponseEntity<?> correrSemilla(){
        try{
            MINCON.correrSemilla();
            return new ResponseEntity<String>("se agregaron Datos", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/cliente")
    public ResponseEntity<?> obtenerClientes(){
        try{
            Map<String, Object> respJson=MINCON.obtenerClientes();
            return new ResponseEntity<Map<String, Object>>(respJson, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_GATEWAY);
        }
    }

    @GetMapping("/contratos")
    public ResponseEntity<?> obtenerContratos(){
        try{
            Map<String, Object> respJson=MINCON.obtenerContratos();
            return new ResponseEntity<Map<String, Object>>(respJson, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_GATEWAY);
        }
    }

    @PostMapping(path = "/reporte")
    public ResponseEntity<?> reporte(@RequestBody bodyReporte body){
        try{
            Map<String, Object> respJson = MINCON.generarReporte(body);
            return new ResponseEntity<Map<String, Object>>(respJson, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_GATEWAY);
        }
    }
}

