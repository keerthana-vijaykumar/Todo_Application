package com.keerthana.todo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class TodoService implements ITodoService {

    List<Todo> todos = new ArrayList<Todo>();

    @Override
    public void addTodo(String content) {
        int id = Todo.count;

        Todo newTodo = new Todo(id, content, "Active");

        todos.add(newTodo);
    }

    @Override
    public void updateTodo(long id, String content) {
        todos.forEach(_todo -> {
            if (Objects.equals(_todo.getId(), id))
                _todo.setContent(content);
        });
    }

    @Override
    public void deleteTodo(long id) {
        todos.forEach(_todo -> {
            if (Objects.equals(_todo.getId(), id))
                _todo.setStatus("Deleted");
        });
    }

    @Override
    public Todo getTodoById(long id) throws Exception {
        Optional<Todo> todo = todos.stream()
                .filter(_todo -> Objects.equals(_todo.getId(), id)).findFirst();

        if (todo.isPresent())
            return todo.get();

        else
            throw new Exception("Element not found");
    }

    @Override
    public List<Todo> getAllTodos() {
        return todos;
    }
}
