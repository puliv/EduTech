package com.example.edutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.edutech.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {
  Rol findByNombreRol(String nombreRol);
}
