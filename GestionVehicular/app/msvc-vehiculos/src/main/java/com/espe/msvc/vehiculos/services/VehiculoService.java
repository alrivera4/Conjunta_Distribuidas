/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.espe.msvc.vehiculos.services;

import com.espe.msvc.vehiculos.models.entity.Vehiculo;
import com.espe.msvc.vehiculos.models.entity.Propietario;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author USER
 */
public interface VehiculoService {
    
    List<Vehiculo> listar();
    Vehiculo guardar(Vehiculo curso);
    void eliminar(Long id);
    Optional<Vehiculo> porId(Long id);
    
    
    Optional<Propietario> agregarUsuario(Propietario usuario, Long idCurso);
    Optional<Propietario> crearUsuario(Propietario usuario, Long idCurso);
    
    //El metodo eliminarUsuarios elimina el usuario del curso
    Optional<Propietario> eliminarUsuario(Propietario usuario, Long idCurso);
    
    
}
