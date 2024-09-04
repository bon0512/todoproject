package com.example.todoproject.api;


import com.example.todoproject.entity.Todo;
import com.example.todoproject.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoApiController {

    @Autowired
    private TodoRepository todoRepository;


    //GET 전체 목록 조회(메인홈페이지)
    @GetMapping("/api/todo")
    public List<Todo> index(){

        return todoRepository.findAll();
    }



    //POST 추가

    //DELETE 삭제


}
