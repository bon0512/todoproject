package com.example.todoproject.api;


import com.example.todoproject.dto.TodoForm;
import com.example.todoproject.entity.Todo;
import com.example.todoproject.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/api/createtodo")
    public Todo create(@RequestBody TodoForm dto){

        Long maxOrderNumber = todoRepository.findMaxOrderNumber();

        Long newOrderNumber = (maxOrderNumber !=null)?maxOrderNumber+1:1;

        Todo todo = dto.toEntity(newOrderNumber);

        return todoRepository.save(todo);
    }


    //DELETE 삭제

    @DeleteMapping("/api/todo/{id}")
    public ResponseEntity<Todo> delete(@PathVariable("id") Long id ){
        //1.DB에서 대상 엔티티가 있는지 조회하기

        Todo target = todoRepository.findById(id).orElse(null);


        //2. 대상 엔티티가 없어서 요청 자체가 잘못됐을경우 처리하기
        if(target==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }


        //3. 대상엔티티가 있으면 삭제하고 정상응답 반환하기

        todoRepository.delete(target);
        return ResponseEntity.status(HttpStatus.OK).build();

    }


}
