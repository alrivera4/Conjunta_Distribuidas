/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.espe.msvc.propietarios.services;

import com.espe.msvc.propietarios.models.entity.Propietario;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author USER
 */
public interface PropietarioService {
    List<Propietario>listar();
    Optional<Propietario> porId (long id);
    Propietario guardar(Propietario usuario);
    void eliminar(Long id);
    
}
