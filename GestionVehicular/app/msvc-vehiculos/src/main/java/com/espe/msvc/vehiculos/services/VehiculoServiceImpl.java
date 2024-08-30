/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.espe.msvc.vehiculos.services;

import com.espe.msvc.vehiculos.models.entity.Vehiculo;
import com.espe.msvc.vehiculos.models.entity.VehiculoPropietario;
import com.espe.msvc.vehiculos.models.entity.Propietario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.espe.msvc.vehiculos.clients.PropietarioClientRest;
import com.espe.msvc.vehiculos.repositories.VehiculoRepository;

/**
 *
 * @author USER
 */

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    PropietarioClientRest usuarioClientRest;
    
    @Override
    @Transactional(readOnly = true)
    public List<Vehiculo> listar() {
        return (List<Vehiculo>) vehiculoRepository.findAll();
    }

    @Override
    public Vehiculo guardar(Vehiculo curso) {
        return vehiculoRepository.save(curso);
    }

    @Override
    public void eliminar(Long id) {
        vehiculoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly= true)
    public Optional<Vehiculo> porId(Long id) {
        return vehiculoRepository.findById(id);
    }

    @Override
    public Optional<Propietario> agregarUsuario(Propietario usuario, Long idCurso) {
        Optional<Vehiculo> o = vehiculoRepository.findById(idCurso);
        if(o.isPresent()){
            Propietario usuarioMicro = usuarioClientRest.detalle(usuario.getId());
            Vehiculo vehiculo = o.get();
            VehiculoPropietario vehiculoPropietario = new VehiculoPropietario();
           vehiculoPropietario.setPropietarioId(usuarioMicro.getId());
            
           vehiculo.addVehiculoPropietario(vehiculoPropietario);
           vehiculoRepository.save(vehiculo);
        }
        
        return Optional.empty();
    }

    @Override
    public Optional<Propietario> crearUsuario(Propietario usuario, Long idCurso) {
         Optional<Vehiculo> o = vehiculoRepository.findById(idCurso);
        if(o.isPresent()){
            Propietario usuarioMicro = usuarioClientRest.detalle(usuario.getId());

            Vehiculo vehiculo = o.get();
            VehiculoPropietario vehiculoPropietario = new VehiculoPropietario();
            vehiculoPropietario.setPropietarioId(usuarioMicro.getId());

            vehiculo.addVehiculoPropietario(vehiculoPropietario);
            vehiculoRepository.save(vehiculo);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Propietario> eliminarUsuario(Propietario usuario, Long idCurso) {
        Optional<Vehiculo> o = vehiculoRepository.findById(idCurso);
        if(o.isPresent()){
            Propietario usuarioMicro = usuarioClientRest.crear(usuario);

            Vehiculo vehiculo = o.get();
            VehiculoPropietario  vehiculoPropietario = new VehiculoPropietario();
            vehiculoPropietario.setPropietarioId(usuarioMicro.getId());

            vehiculo.removeVehiculoPropietario(vehiculoPropietario);
            vehiculoRepository.save(vehiculo);
        }

        return Optional.empty();
    }
}
