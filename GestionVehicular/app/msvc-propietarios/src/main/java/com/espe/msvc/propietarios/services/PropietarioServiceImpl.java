/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espe.msvc.propietarios.services;

import com.espe.msvc.propietarios.models.entity.Propietario;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.espe.msvc.propietarios.repositories.PropietarioRepository;



/**
 *
 * @author USER
 */
@Service
public class PropietarioServiceImpl implements PropietarioService{

    @Autowired
    private PropietarioRepository repository;
    
   
    @Override
    @Transactional(readOnly = true)
    public List<Propietario> listar() {
        return (List<Propietario>) repository.findAll();
    }
    
    @Override
    @Transactional
    public Propietario guardar(Propietario usuario) {
        return repository.save(usuario);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly= true)
    public Optional<Propietario> porId(long id) {
        return repository.findById(id);
    }

   
    
}
