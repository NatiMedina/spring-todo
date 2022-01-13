package com.naty.todo.Controllers;

import com.naty.todo.Models.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UsuarioController {

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
