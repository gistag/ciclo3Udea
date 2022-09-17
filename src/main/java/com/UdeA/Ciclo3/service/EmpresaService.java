package com.UdeA.Ciclo3.service;

import com.UdeA.Ciclo3.modelos.Empresa;
import com.UdeA.Ciclo3.repo.EmpresaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaService {
    @Autowired //Conectamos esta clase con el repository de Empresa
    EmpresaRepositorio empresaRepository; //Creamos un objeto tipo EmpresaRepository para poder usar los metodos que dicha clase hereda

    //Método que retorna la lista de empresas usando heredados del jpaRepository
    public List<Empresa> getAllEmpresas(){
        List<Empresa> empresalist = new ArrayList<>();
        empresaRepository.findAll().forEach(empresa->empresalist.add(empresa));//Recorremos el iterable que regresa el método findAll del JPA y lo guardamos en la lista
        return empresalist;
    }

    //Metodo que se trae un objeto de tipo Emmpresa usando el id de la misma
    public Empresa getEmpresaById(Integer id){
        return empresaRepository.findById(id).get();
    }


    //Metodo para guardar o actualizar objetos de tipo Empresa
    public boolean saveOrUpdateEmpresa2(Empresa empresa){
        Empresa emp = empresaRepository.save(empresa);
        if(empresaRepository.findById(emp.getId())!=null){
            return true;
        }
        return false;
    }
    public Empresa saveOrUpdateEmpresa(Empresa empresa){
        Empresa emp = empresaRepository.save(empresa);

        return emp;
    }
    //método delete pendiente
    public boolean deleteEmpresa(Integer id){
        empresaRepository.deleteById(id); //Eliminar Empresa
        if(empresaRepository.findById(id)!=null){
            return true;
        }
        else {return false;}
    }

}
