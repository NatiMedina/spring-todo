package com.naty.todo.dao;

import com.naty.todo.models.Todo;
import com.naty.todo.models.Usuario;

import java.util.List;

public interface UsuarioDao {

    List<Usuario> getUsuarios();

    Usuario crearUsuario(Usuario usuario);

    Usuario modificarUsuario(Long id, Usuario usuario);


}
