package com.example.todoproject.dto;

import com.example.todoproject.entity.Todo;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TodoForm {
    private String content; //할일을 받을 필드


    public TodoForm(){

    }
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
        return new Todo(null,null,content,"In prograss");
    }

    public Todo toEntity(Long orderNumber){
        return new Todo(null,orderNumber,content,"In prograss");
    }
}
