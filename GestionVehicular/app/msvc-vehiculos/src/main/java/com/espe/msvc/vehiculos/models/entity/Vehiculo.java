package com.espe.msvc.vehiculos.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */



@Entity
@Table(name="vehiculos")
public class Vehiculo {
    
    //Atributos  //número de matrícula, marca, modelo, año, y propietario.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String numeroMatricula;
    
    @NotEmpty
    private String modelo;
    
    @NotEmpty
    private String anio;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch= FetchType.LAZY)
    @JoinColumn(name="vehiculo_id")
    private List<VehiculoPropietario> vehiculoPropietarios;

    @Transient
    private List<Propietario> propietarios;
    
    //Constructores
    public Vehiculo(){
       
        vehiculoPropietarios=new ArrayList<>();
        propietarios= new ArrayList<>();
    }
    
    
    //Getter y Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public List<VehiculoPropietario> getVehiculoPropietarios() {
        return vehiculoPropietarios;
    }

    public void setVehiculoPropietarios(List<VehiculoPropietario> vehiculoPropietarios) {
        this.vehiculoPropietarios = vehiculoPropietarios;
    }

    public List<Propietario> getPropietarios() {
        return propietarios;
    }

    public void setPropietarios(List<Propietario> propietarios) {
        this.propietarios = propietarios;
    }

    public void addVehiculoPropietario(VehiculoPropietario vehiculoPropietario){
        vehiculoPropietarios.add(vehiculoPropietario);
    }
    
    public void removeVehiculoPropietario(VehiculoPropietario vehiculoPropietario){
        vehiculoPropietarios.remove(vehiculoPropietario);
    }
    
    
}
