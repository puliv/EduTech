package com.example.edutech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.edutech.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
  List<Usuario> findAll();
  Usuario findById(@Param("id") int id);
}
