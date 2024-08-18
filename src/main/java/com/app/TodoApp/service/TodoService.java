package com.app.TodoApp.service;

import com.app.TodoApp.model.Todo;
import com.app.TodoApp.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepo repo;

    public List<Todo> getAllTodos(){
        return repo.findAll();
    }

    public boolean addTodo(Todo todo){
        try {
            repo.save(todo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteTodo(int todoID){
        try{
            repo.deleteById(todoID);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean updateTodo(Todo todo, int todoID){
        try{
            repo.save(todo);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
