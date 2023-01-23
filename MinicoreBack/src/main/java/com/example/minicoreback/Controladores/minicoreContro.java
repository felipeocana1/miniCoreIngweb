package com.example.minicoreback.Controladores;

import com.example.minicoreback.Entidades.Cliente;
import com.example.minicoreback.Entidades.Contrato;
import com.example.minicoreback.Entidades.bodyReporte;
import com.example.minicoreback.Entidades.minicore;
import com.example.minicoreback.Modelos.clienteRepositorio;
import com.example.minicoreback.Modelos.contratoRepositorio;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.*;

@Controller
public class minicoreContro {
    @Autowired
    private clienteRepositorio CLIR;
    @Autowired
    private contratoRepositorio CONR;

    public void correrSemilla(){
        Random random = new Random();
        Faker faker = new Faker();

        ArrayList<String> list= new ArrayList<>();
        list.add(CLIR.save(new Cliente("UDLA")).getId());
        list.add(CLIR.save(new Cliente("Supermaxi")).getId());
        list.add(CLIR.save(new Cliente("Cigarra")).getId());
        list.add(CLIR.save(new Cliente("Microsoft")).getId());

        for (String i: list) {
            int x = random.nextInt(5);
            for (int j = 0; j < x; j++) {
                String nombre = faker.lorem().sentence();
                Date fecha = faker.date().birthday();
                float monto= (float) ((Math.random())*(100000000.99-100000.00)+100000.00);
                CONR.save(new Contrato(nombre,monto,fecha,i));
            }

        }
    }

    public Map<String, Object> generarReporte(bodyReporte fechas){
        Map<String, Object> respJson = new HashMap<String,Object>();
        List<minicore> resultado =new ArrayList<>();
        List<Contrato> contratos = CONR.findAll().stream().filter(contrato -> (contrato.getFecha().compareTo(fechas.fechaIni)>=0 && contrato.getFecha().compareTo(fechas.fechaFin)<=0)).toList();
        List<Cliente> clientes = CLIR.findAll();

        for (Cliente cliente: clientes){
            float total=0;
            for(Contrato contrato:contratos){
                if(contrato.getClienteID().equals(cliente.getId())){
                    total = total + contrato.getMonto();
                }
            }
            resultado.add(new minicore(cliente.getNombre(),total));
        }
        respJson.put("respuesta",resultado);
        return respJson;

    }


    public Map<String, Object> obtenerClientes(){
        Map<String, Object> respJson = new HashMap<String,Object>();
        List<Cliente> clientes = CLIR.findAll();
        respJson.put("Clientes",clientes);
        return respJson;
    }

    public Map<String, Object> obtenerContratos(){
        Map<String, Object> respJson = new HashMap<String,Object>();
        List<Contrato> contratos = CONR.findAll();
        respJson.put("Contratos",contratos);
        return respJson;
    }

}
