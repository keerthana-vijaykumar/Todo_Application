package com.keerthana.todo;

public class Todo {

    private long id;
    private String content;
    private String status;
    public static int count = 0;

    public Todo(long id, String content, String status) {
        this.id = id;
        this.content = content;
        this.status = status;
        count++;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
