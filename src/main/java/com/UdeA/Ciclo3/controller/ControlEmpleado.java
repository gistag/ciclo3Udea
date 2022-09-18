package com.UdeA.Ciclo3.controller;

import com.UdeA.Ciclo3.modelos.Empleado;
import com.UdeA.Ciclo3.modelos.Empresa;
import com.UdeA.Ciclo3.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControlEmpleado {

    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/users")
    public List<Empleado> verEmpleados() {
        return empleadoService.getAllEmpleados();
    }

    @PostMapping("/users")
    public Empleado guardarEmpleado(@RequestBody Empleado emp) {
        return this.empleadoService.saveOrUpdateEmpleado(emp);
    }

    @GetMapping(path = "/users/{id}")
    public Empleado empleadoPorId(@PathVariable("id") Integer id) {

        return this.empleadoService.getEmpleadoById(id);
    }

    @PatchMapping("/users/{id}")
    public Empleado actualizarEmpleado(@PathVariable("id") Integer id, @RequestBody Empleado empleado){
        Empleado emp = empleadoService.getEmpleadoById(id);
        emp.setNombre(empleado.getNombre());
        emp.setCorreo(empleado.getCorreo());
        emp.setRol(empleado.getRol());
        emp.setEmpresa(empleado.getEmpresa());
        return empleadoService.saveOrUpdateEmpleado(emp);
    }


    @DeleteMapping (path = "/users/{id}")//Eliminar registros de la base de datos
    public String DeleteEmpleado(@PathVariable("id") Integer id){
        boolean respuesta = this.empleadoService.deleteEmpleado(id);
        if(respuesta){//si respuesta es true
            return "se elimino el empleado con el id" + id;
        }
        else {
            return "no se pudo eliminar el empleado con el id " + id;
        }
    }


}
