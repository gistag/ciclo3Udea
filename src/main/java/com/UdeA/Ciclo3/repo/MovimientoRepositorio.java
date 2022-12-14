package com.UdeA.Ciclo3.repo;

import com.UdeA.Ciclo3.modelos.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MovimientoRepositorio extends JpaRepository<MovimientoDinero,Integer> {
//Metodo para filtrar movimientos por empleado
    @Query(value = "SELECT * FROM movimientos WHERE empleado_id = ?1", nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> findByEmpleado(Integer id);

    //Metodo para filtrar movimientos por empresa
    @Query(value = "SELECT * FROM movimientos WHERE empresa_id in (SELECT id from empleado where empresa_id = ?1)", nativeQuery = true)
    public abstract ArrayList<MovimientoDinero> findByEmpresa(Integer id);
}