package com.example.edutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.edutech.model.Rol;
import com.example.edutech.repository.RolRepository;

@Service
public class RolService {
  @Autowired
  private RolRepository rolRepository;

  public String crearRol(Rol rol) {
    String nombre = rol.getNombreRol();
    System.out.println("Creando rol: " + nombre);

    if (nombre == null || nombre.isEmpty()) {
      return "El nombre del rol no puede estar vacío";
    }

    Rol existe = rolRepository.findByNombreRol(nombre);
    if (existe != null) {
      return "El rol ya existe";
    } else {
      Rol nuevoRol = new Rol();
      nuevoRol.setNombreRol(nombre);
      nuevoRol.setDescripcion(rol.getDescripcion());
      rolRepository.save(nuevoRol);
      return "Rol creado exitosamente";
    }
  }

  public List<Rol> obtenerRoles() {
    return rolRepository.findAll();
  }
}
