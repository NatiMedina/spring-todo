package com.naty.todo.dao;

import com.naty.todo.models.Todo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class TodoDaoImp implements TodoDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Todo> getTodos() {
        String query = "FROM Todo";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Todo crearTodo(Todo todo) {
        todo.setCreacion(new Date());
        entityManager.persist(todo);
        return todo;
    }

    @Override
    public void eliminarTodo(Long id) {
        Todo todo = entityManager.find(Todo.class, id);
        if (todo != null) {
            entityManager.remove(todo);
        }
    }

    @Override
    public Todo modificarTodo(Long id, Todo todo) {
        Todo oldTodo = entityManager.find(Todo.class, id);
        if (oldTodo != null && todo != null) {
            if (todo.getTitulo() != null) {
                oldTodo.setTitulo(todo.getTitulo());
            }
            oldTodo.setEstado(todo.getEstado());
            if (todo.getDescripcion() != null){
                oldTodo.setDescripcion(todo.getDescripcion());
            }
            oldTodo.setModificacion(new Date());
            oldTodo.setVencimiento(todo.getVencimiento());
            oldTodo.setPrioridad(todo.getPrioridad());
        }
        return oldTodo;
    }

}

