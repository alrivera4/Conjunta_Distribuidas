/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.espe.msvc.vehiculos.clients;

import com.espe.msvc.vehiculos.models.entity.Propietario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author USER
 */

@FeignClient(name="msvc-propietarios", url="localhost:8001")
public interface PropietarioClientRest {
    
    @GetMapping("/{id}")
    Propietario detalle(@PathVariable Long id);
    
    @PostMapping
    Propietario crear(@RequestBody Propietario usuario);
    
}
