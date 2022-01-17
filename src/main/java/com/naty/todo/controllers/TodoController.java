package com.naty.todo.controllers;

import com.naty.todo.models.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class TodoController {

    private static List<Todo> todos = new ArrayList<>();

    @RequestMapping(value = "api/todo", method = RequestMethod.POST)
    public Todo createTodo(@RequestBody Todo todo){
        if(todo != null){
            todos.add(todo);
            todo.setCreacion(new Date());
            todo.setId((long) todos.size());
        }
        return todo;
    }

    @RequestMapping(value = "api/todos")
    public List<Todo> getTodos(){
        return todos;
    }

}
