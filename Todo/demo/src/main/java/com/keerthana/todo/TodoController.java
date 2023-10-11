package com.keerthana.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private ITodoService todoService;

    @RequestMapping(method = RequestMethod.GET, path = "todos", produces = "application/json")
    public List<Todo> getTodos() {
        return todoService.getAllTodos();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/todos/{id}")
    public Todo getTodoById(@PathVariable long id) throws Exception {
        return todoService.getTodoById(id);
    }


    @RequestMapping(method = RequestMethod.POST, path = "/todos/add")
    public String addTodo(@RequestBody String content) {
        todoService.addTodo(content);

        return "Todo created successfully";
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/todos/update/{id}")
    public String updateTodo(@PathVariable long id, @RequestBody String content){
        todoService.updateTodo(id, content);

        return "Todo updated successfully";
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/todos/delete/{id}")
    public String deleteTodo(@PathVariable long id){
        todoService.deleteTodo(id);

        return "Todo deleted successfully";
    }

    RestTemplate restTemplate = new RestTemplate();
    String fooResourceUrl = "http://localhost:8080/";
    Todo todo = restTemplate.getForObject(fooResourceUrl, Todo.class);
}
