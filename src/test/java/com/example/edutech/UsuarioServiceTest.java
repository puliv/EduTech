package com.example.edutech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.edutech.model.Usuario;
import com.example.edutech.repository.UsuarioRepository;
import com.example.edutech.service.UsuarioService;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {
  // con @Mock se crea un obj falso que permite controlar el comportamiento de un
  // objeto real
  @Mock
  private UsuarioRepository usuarioRepository;
  @InjectMocks
  // con mockbean se crea un objeto falso que permite controlar el comportamiento
  // de un objeto real
  private UsuarioService usuarioService;

  @Test
  void almacenarUsuarioRepetido() {
    Usuario usuario = new Usuario();

    usuario.setNombre("Juan Perez");
    usuario.setContrasena("12345");
    usuario.setCorreo("juan@mail.com");

    // Simular el comportamiento del repositorio
    when(usuarioRepository.existsById(1)).thenReturn(true);

    String resultado = usuarioService.crearUsuario(usuario);

    assertEquals("El usuario ya existe", resultado);
  }

  @Test
  void listarUsuarios() {
    Usuario usuario1 = new Usuario();
    usuario1.setNombre("Juan Perez");
    usuario1.setContrasena("12345");
    usuario1.setCorreo("mail@mail.com");

    Usuario usuario2 = new Usuario();
    usuario2.setNombre("Maria Lopez");
    usuario2.setContrasena("54321");
    usuario2.setCorreo("correo@ciaml.com");

    List<Usuario> listaUsuarios = new ArrayList<>();
    listaUsuarios.add(usuario1);
    listaUsuarios.add(usuario2);

    when(usuarioRepository.findAll()).thenReturn(listaUsuarios);

    List<Usuario> resultado = usuarioService.obtenerUsuarios();

    assertEquals(2, resultado.size());
  }
}
