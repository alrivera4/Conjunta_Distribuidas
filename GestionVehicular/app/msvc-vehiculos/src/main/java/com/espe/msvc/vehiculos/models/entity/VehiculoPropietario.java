/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espe.msvc.vehiculos.models.entity;

import jakarta.persistence.*;

/**
 *
 * @author USER
 */

@Entity
@Table(name="vehiculo-propietario")
public class VehiculoPropietario {
    
    //Atributos
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="propietario_id", unique=true)
    private Long propietarioId;
    
    //Constructores

    public VehiculoPropietario(){
        
    }
    
    public VehiculoPropietario(Long id, Long propietarioId) {
        this.id = id;
        this.propietarioId = propietarioId;
    }
    
    //Getter y Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPropietarioId() {
        return propietarioId;
    }

    public void setPropietarioId(Long propietarioId) {
        this.propietarioId = propietarioId;
    }

   
    
    
    
    
    
    
    
}
