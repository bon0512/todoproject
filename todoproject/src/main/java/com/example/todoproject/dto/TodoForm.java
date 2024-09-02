package com.example.todoproject.dto;

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
}
