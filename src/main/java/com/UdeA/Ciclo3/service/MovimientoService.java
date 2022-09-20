package com.UdeA.Ciclo3.service;

import com.UdeA.Ciclo3.modelos.MovimientoDinero;
import com.UdeA.Ciclo3.repo.MovimientoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoService {
    @Autowired
    MovimientoRepositorio movimientoRepositorio;
    //Metodo que muestra todos los movimientos sin ningun filtro
    public List<MovimientoDinero> getAllMovimientos() {
        List<MovimientoDinero> movimientoDineroList = new ArrayList<>();
        movimientoRepositorio.findAll().forEach(movimientoDinero -> movimientoDineroList.add(movimientoDinero));
        return movimientoDineroList;
    }
    //Ver movimientos por ID
    public MovimientoDinero getMovimientoById(Integer id) {
        return movimientoRepositorio.findById(id).get();
    }
    //guardar o actualizar elementos
    public MovimientoDinero saveOrUpdateMovimiento(MovimientoDinero movimientoDinero) {
        MovimientoDinero mov = movimientoRepositorio.save(movimientoDinero);
        return mov;
    }
    //Eliminar movimientos con el id
    public boolean deleteMovimiento(Integer id){
        movimientoRepositorio.deleteById(id); //Eliminar Movimiento
        if(this.movimientoRepositorio.findById(id).isPresent()){
            return false;
        }
        return true;//cuando se haya buscado el movimiento y no sea encontrado, quiere decir que si lo eliminó
    }

    public ArrayList<MovimientoDinero> obtenerPorEmpleado(Integer id){
        return movimientoRepositorio.findByEmpleado(id);
    }

    public ArrayList<MovimientoDinero> obtenerPorEmpresa(Integer id){
        return movimientoRepositorio.findByEmpresa(id);
    }

}
