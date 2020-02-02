package com.modul_120.todo_application.todo.services;

import com.modul_120.todo_application.todo.Todo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@CrossOrigin("http://localhost:4200")
@Service
public class toDoHardcodedService {

    private static List<Todo> toDos = new ArrayList();
    private static long idCounter = 0;


    static {
        toDos.add(new Todo(++idCounter, "Simon Gadola", "Learn to Dance", new Date(), false));
        toDos.add(new Todo(++idCounter, "Simon Gadola", "Learn about microservices", new Date(), false));
        toDos.add(new Todo(++idCounter, "Simon Gadola", "Learn about Angular", new Date(), false));
    }

    public List<Todo> findAll() {
        return toDos;
    }


    public Todo save(Todo todo) {
        long id = todo.getId();

        if (id == -1)
            todo.setId(++idCounter);
        else
            deleteById(id);

        toDos.add(todo);
        return todo;
}


    public Todo deleteById(long id) {
        Todo todo = findById(id);

        if (todo == null)
            return null;

        if (toDos.remove(todo))
            return todo;

        return null;
    }


    public Todo findById(long id) {
        for (Todo todo : toDos)
            if (todo.getId() == id)
                return todo;

        return null;
    }
}