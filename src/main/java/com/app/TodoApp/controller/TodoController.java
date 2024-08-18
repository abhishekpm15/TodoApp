package com.app.TodoApp.controller;

import com.app.TodoApp.model.Todo;
import com.app.TodoApp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TodoController {

    @Autowired
    private TodoService service;

    @RequestMapping("/")
    public ResponseEntity<String> homePage(){
        return new ResponseEntity<>("Host Works", HttpStatus.OK);
    }

    @RequestMapping("/todos")
    public ResponseEntity<List<Todo>> getAllTodos(){
        List<Todo> todos = service.getAllTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @PostMapping("/addTodo")
    public ResponseEntity<Boolean> addTodo(@RequestBody Todo todo){
        boolean result = service.addTodo(todo);
        return new ResponseEntity<>(result, result ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/deleteTodo/{todoID}")
    public ResponseEntity<Boolean> deleteTodo(@PathVariable int todoID){
        boolean result = service.deleteTodo(todoID);
        return new ResponseEntity<>(result, result ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PutMapping("/updateTodo/{todoID}")
    public ResponseEntity<Boolean> updateTodo(@RequestBody Todo todo, @PathVariable int todoID){
        System.out.println("Todo ID: " + todoID);
        boolean result = service.updateTodo(todo, todoID);
        return new ResponseEntity<>(result, result ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
