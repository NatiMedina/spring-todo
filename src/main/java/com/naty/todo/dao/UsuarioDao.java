package com.naty.todo.dao;

import com.naty.todo.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUsuarios();

    Usuario crearUsuario(Usuario usuario);

    void eliminarUsuario(Long id);

}
