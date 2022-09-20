package com.UdeA.Ciclo3.controller;

import com.UdeA.Ciclo3.modelos.MovimientoDinero;
import com.UdeA.Ciclo3.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControlMovimientoDinero {
    @Autowired
    MovimientoService movimientoService;

    @GetMapping("/movements")
    public List<MovimientoDinero> verMovimientos() {
        return movimientoService.getAllMovimientos();
    }

    @PostMapping("/movements")
    public MovimientoDinero guardarMovimiento(@RequestBody MovimientoDinero mov) {
        return movimientoService.saveOrUpdateMovimiento(mov);
    }

    @GetMapping("/movements/{id}")
    public MovimientoDinero movimientoPorId(@PathVariable("id") Integer id) {
        return movimientoService.getMovimientoById(id);
    }

    @PatchMapping("/movements/{id}")
    public MovimientoDinero actualizarMovimiento(@PathVariable("id") Integer id, @RequestBody MovimientoDinero movimiento){
        MovimientoDinero mov = movimientoService.getMovimientoById(id);
        mov.setConcepto(movimiento.getConcepto());
        mov.setMonto(movimiento.getMonto());
        mov.setUsuario(movimiento.getUsuario());
        return movimientoService.saveOrUpdateMovimiento(mov);
    }

    @DeleteMapping("/movements/{id}")//Eliminar registros de la base de datos
    public String DeleteMovimiento(@PathVariable("id") Integer id){
        boolean respuesta = movimientoService.deleteMovimiento(id);
        if(respuesta){//si respuesta es true
            return "se elimino el movimiento con el id" + id;
        }
        else {
            return "no se pudo eliminar el movimiento con el id " + id;
        }
    }
    //Consultar movimientos por id del empleado
    @GetMapping("/users({id})/movements")
    public ArrayList<MovimientoDinero> movimientoPorEmpleado(@PathVariable("id") Integer id){
        return movimientoService.obtenerPorEmpleado(id);
    }
    //Consultar movimientos que pertenecen a una empresa por id
    @GetMapping("/enterprises({id})/movements")
    public ArrayList<MovimientoDinero> movimientoPorEmpresa(@PathVariable("id") Integer id){
        return movimientoService.obtenerPorEmpresa(id);
    }


}
