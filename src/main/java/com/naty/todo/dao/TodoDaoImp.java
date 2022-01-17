package com.naty.todo.dao;

import com.naty.todo.models.Todo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TodoDaoImp implements TodoDao {

    @Override
    public List<Todo> getTodos() {
        return null;
    }

}

