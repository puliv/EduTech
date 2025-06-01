package com.example.edutech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.edutech.model.Usuario;
import com.example.edutech.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
  @Autowired
  private UsuarioService usuarioService;

  @PostMapping
  public String crearUsuario(@RequestBody Usuario usuario) {
    return usuarioService.crearUsuario(usuario);
  }

  @GetMapping
  public List<Usuario> obtenerUsuarios() {
    return usuarioService.obtenerUsuarios();
  }
}
