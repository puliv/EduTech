package com.example.edutech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.edutech.model.Rol;
import com.example.edutech.model.Usuario;
import com.example.edutech.repository.RolRepository;
import com.example.edutech.repository.UsuarioRepository;

@Service
public class UsuarioService {
  @Autowired
  private UsuarioRepository usuarioRepository;
  private RolRepository rolRepository;

  public String crearUsuario(Usuario usuario) {
    if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) {
      return "El nombre no puede estar vacío";
    }
    if (usuario.getContrasena() == null || usuario.getContrasena().isEmpty()) {
      return "La contraseña no puede estar vacía";
    }

    usuarioRepository.save(usuario);
    return "Usuario creado exitosamente";
  }

  public List<Usuario> obtenerUsuarios() {
    return usuarioRepository.findAll();
  }

  public String asignarRolAUsuario(Integer usuarioId, Integer rolId) {
    Usuario usuario = usuarioRepository.findById(usuarioId).orElse(null);
    Rol rol = rolRepository.findById(rolId).orElse(null);

    if (usuario == null) {
      return "Usuario no encontrado";
    }

    if (rol == null) {
      return "Rol no encontrado";
    }

    // usuario.getRol().add(rol);
    usuarioRepository.save(usuario);
    return "Rol asignado exitosamente al usuario";
  }

}
