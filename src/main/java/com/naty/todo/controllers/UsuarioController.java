package com.naty.todo.controllers;

import com.naty.todo.dao.UsuarioDao;
import com.naty.todo.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getTodos() {
        return usuarioDao.getUsuarios();
    }


    @RequestMapping(value = "api/usuario", method = RequestMethod.POST)
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioDao.crearUsuario(usuario);
    }
}
