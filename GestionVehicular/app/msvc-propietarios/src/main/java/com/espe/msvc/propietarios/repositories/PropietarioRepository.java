/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.espe.msvc.propietarios.repositories;

import com.espe.msvc.propietarios.models.entity.Propietario;
import org.springframework.data.repository.CrudRepository;


public interface PropietarioRepository extends CrudRepository<Propietario, Long> {
    
}
