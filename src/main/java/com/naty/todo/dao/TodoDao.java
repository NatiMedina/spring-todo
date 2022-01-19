package com.naty.todo.dao;

import com.naty.todo.models.Todo;

import java.util.List;

public interface TodoDao {

    List<Todo> getTodos();

    Todo crearTodo(Todo todo);

    void eliminarTodo(Long id);

    Todo modificarTodo(Long id, Todo todo);
}
