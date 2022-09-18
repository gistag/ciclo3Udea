package com.UdeA.Ciclo3.repo;

import com.UdeA.Ciclo3.modelos.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado,Integer> {
}
