package com.example.edutech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.edutech.model.Rol;
import com.example.edutech.service.RolService;

@RestController
@RequestMapping("/rol")
public class RolController {
  @Autowired
  private RolService rolService;

  @GetMapping
  public List<Rol> obtenerRoles() {
    return rolService.obtenerRoles();
  }

  @PostMapping
  public String crearRol(@RequestBody Rol rol) {
    return rolService.crearRol(rol);
  }
}
