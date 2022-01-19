package com.naty.todo.controllers;

import com.naty.todo.dao.TodoDao;
import com.naty.todo.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoDao todoDao;

    @RequestMapping(value = "api/todo", method = RequestMethod.POST)
    public Todo createTodo(@RequestBody Todo todo) {
       return todoDao.crearTodo(todo);
    }

    @RequestMapping(value = "api/todos", method = RequestMethod.GET)
    public List<Todo> getTodos() {
        return todoDao.getTodos();
    }

    @RequestMapping(value = "api/todo/{id}", method = RequestMethod.DELETE)
    public void eliminarTodo(@PathVariable Long id) {
        if (id != null) {
            todoDao.eliminarTodo(id);
        }
    }

    @RequestMapping(value = "api/todo/{id}", method = RequestMethod.PATCH)
    public Todo modificarTodo(@PathVariable Long id, @RequestBody Todo todo) {
        return todoDao.modificarTodo(id, todo);
    }

}
