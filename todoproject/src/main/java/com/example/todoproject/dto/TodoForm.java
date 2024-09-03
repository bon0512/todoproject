package com.example.todoproject.dto;

import com.example.todoproject.entity.Todo;

public class TodoForm {
    private String content; //할일을 받을 필드

    public TodoForm(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TodoForm{" +
                "content='" + content + '\'' +
                '}';
    }

    public Todo toEntity() {
        return new Todo(null,content,"In prograss");
    }
}
