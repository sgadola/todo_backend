package com.modul_120.todo_application.todo.controllers;

import com.modul_120.todo_application.todo.Todo;
import com.modul_120.todo_application.todo.services.TodoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@CrossOrigin("http://localhost:4200")
@RestController
public class TodoJpaRessource {

    @Autowired
    private TodoJpaRepository todoJpaRepository;


    @GetMapping("/jpa/users/{username}/todos")
    public List<Todo> getAllToDos(@PathVariable String username) throws InterruptedException {
//      Thread.sleep(3000);
        return todoJpaRepository.findByUsername(username);
    }


    @GetMapping("/jpa/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id) {
//      Thread.sleep(3000);
        return todoJpaRepository.findById(id).get();
    }


    @DeleteMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
        todoJpaRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }


    @PutMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo) {
        todo.setUsername(username);

        Todo todoUpdated = todoJpaRepository.save(todo);

        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }


    @PostMapping("/jpa/users/{username}/todos")
    public ResponseEntity<Todo> createTodo(@PathVariable String username, @RequestBody Todo todo) {
        todo.setUsername(username);

        Todo createdTodo = todoJpaRepository.save(todo);

        // Location
        // Get current ressource URL => {id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}