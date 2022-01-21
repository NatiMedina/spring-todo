package com.naty.todo.controllers;

import com.naty.todo.dao.TodoDao;
import com.naty.todo.models.Todo;
import com.naty.todo.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoDao todoDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/todo", method = RequestMethod.POST)
    public Todo createTodo(@RequestHeader(value = "Authorization") String token, @RequestBody Todo todo) {
        if (validarToken(token)) {
            return todoDao.crearTodo(todo);
        }
        return null;
    }

    @RequestMapping(value = "api/todos", method = RequestMethod.GET)
    public List<Todo> getTodos(@RequestHeader(value = "Authorization") String token) {
        if (!validarToken(token)) {
            return null;
        }
        return todoDao.getTodos();
    }

    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }

    @RequestMapping(value = "api/todo/{id}", method = RequestMethod.DELETE)
    public void eliminarTodo(@RequestHeader(value = "Authorization") String token, @PathVariable Long id) {
        if (validarToken(token) && id != null) {
            todoDao.eliminarTodo(id);
        }
    }

    @RequestMapping(value = "api/todo/{id}", method = RequestMethod.PATCH)
    public Todo modificarTodo(@PathVariable Long id, @RequestBody Todo todo) {
        return todoDao.modificarTodo(id, todo);
    }

}
