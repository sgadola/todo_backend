package com.modul_120.todo_application.todo.controllers;

import com.modul_120.todo_application.todo.Todo;
import com.modul_120.todo_application.todo.services.toDoHardcodedService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@CrossOrigin("http://localhost:4200")
@RestController
public class TodoRessource {

    @Autowired
    private toDoHardcodedService toDoService;


    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllToDos(@PathVariable String username) throws InterruptedException {
//      Thread.sleep(3000);
        return toDoService.findAll();
    }


    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable int id) {
//      Thread.sleep(3000);
        return toDoService.findById(id);
    }


    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id) {
        Todo todo = toDoService.deleteById(id);
        if (todo != null)
            return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }


    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable String id, @RequestBody Todo todo) {
        Todo todoUpdated = toDoService.save(todo);

        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }


    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Todo> createTodo(@PathVariable String username, @RequestBody Todo todo) {
        Todo createdTodo = toDoService.save(todo);

        // Location
        // Get current ressource URL => {id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}