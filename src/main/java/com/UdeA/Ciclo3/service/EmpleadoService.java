package com.UdeA.Ciclo3.service;

import com.UdeA.Ciclo3.modelos.Empleado;
import com.UdeA.Ciclo3.modelos.Empresa;
import com.UdeA.Ciclo3.repo.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoService {

    @Autowired //Conectamos esta clase con el repository de empleado
    EmpleadoRepositorio empleadoRepository; //Creamos un objeto tipo empleadoRepository para poder usar los metodos que dicha clase hereda

    //Método que retorna la lista de empleados usando heredados del jpaRepository
    public List<Empleado> getAllEmpleados(){
        List<Empleado> empleadolist = new ArrayList<>();
        empleadoRepository.findAll().forEach(empleado->empleadolist.add(empleado));//Recorremos el iterable que regresa el método findAll del JPA y lo guardamos en la lista
        return empleadolist;
    }

    //Metodo que se trae un objeto de tipo empleado usando el id de la misma
    public Empleado getEmpleadoById(Integer id){
        return empleadoRepository.findById(id).get();
    }


    public Empleado saveOrUpdateEmpleado(Empleado empleado){
        Empleado emp = empleadoRepository.save(empleado);
        return emp;
    }

    public boolean deleteEmpleado(Integer id){
        empleadoRepository.deleteById(id); //Eliminar Empresa
        if(empleadoRepository.findById(id)!=null){
            return true;
        }
        else {return false;}
    }





}
