/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gt.examen.services;

import com.gt.examen.models.DestinatarioModel;
import com.gt.examen.dtos.ActualizarDto;
import com.gt.examen.dtos.CreacionDto;
import com.gt.examen.dtos.RespuestaDto;
import com.gt.examen.repositories.DestinatarioRepository;
import java.util.List;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JairoJS
 */
@Service
@Slf4j
@Transactional
public class DestinatarioServices {

    @Autowired
    DestinatarioRepository destinatarioRepository;

    public RespuestaDto crearDestinatario(CreacionDto creacion) {
     log.debug("Creando Destinatario...");

        DestinatarioModel destinatario = destinatarioRepository.save(
                DestinatarioModel.builder()
                        .nombreDestinatario(creacion.getNombreDestinatario())
                        .apellidoDestinatario(creacion.getApellidoDestinatario())
                        .direccionDestinatario(creacion.getDireccionDestinatario())
                        .numeroDestinatario(creacion.getNumeroDestinatario())
                        .correoDestinatario(creacion.getCorreoDestinatario())
                        .build()
        );
        return new RespuestaDto(destinatario.getIdDestinatario());
    }
    
    public void actualizarDestinatario(Integer idSolicitud, ActualizarDto actualizar) {
        log.debug("Consultando una Destinatario");
        final DestinatarioModel destinatarioModel = this.destinatarioRepository.findById(idSolicitud).orElse(null);
        if (destinatarioModel != null) {
            destinatarioModel.setNombreDestinatario(actualizar.getNombreDestinatario());
            destinatarioModel.setApellidoDestinatario(actualizar.getApellidoDestinatario());
            destinatarioModel.setDireccionDestinatario(actualizar.getDireccionDestinatario());
            destinatarioModel.setNumeroDestinatario(actualizar.getNumeroDestinatario());
            destinatarioModel.setCorreoDestinatario(actualizar.getCorreoDestinatario()); 
        } else {
            return;
        }
    }
    
   
    public void deleteDestinatario(int id){
        destinatarioRepository.deleteById(id);
    }
    
    public boolean existById(int id){
        return destinatarioRepository.existsById(id);
    }
    
    public DestinatarioModel obtenerDestinatario(int id){
        return destinatarioRepository.findById(id).orElse(null);
    }
     
    public List<DestinatarioModel> findAll() {
        return (List<DestinatarioModel>) destinatarioRepository.findAll();
    }
    
  
}
