package com.keerthana.todo;

import java.util.List;

public interface ITodoService {

    public void addTodo(String content);

    public void updateTodo(long id, String content);

    public void deleteTodo(long id);

    public Todo getTodoById(long id) throws Exception;

    public List<Todo> getAllTodos();
}
