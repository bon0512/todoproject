package com.example.todoproject.controller;

import com.example.todoproject.dto.TodoForm;
import com.example.todoproject.entity.Todo;
import com.example.todoproject.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Slf4j
@Controller
public class ToDoController {

    @Autowired
    private TodoRepository todoRepository;



    @GetMapping("/todo")
    public String indexTodo(Model model){

        ArrayList<Todo> todoEntityList = todoRepository.findAll();

        model.addAttribute("Todo",todoEntityList);
        return"/todos/list";
    }

    @PostMapping("/todo/create")
    public String createTodo(TodoForm form){
        log.info(form.toString());

        //최신 orderNumber를 가져와서 1증가
        Long maxOrderNumber = todoRepository.findMaxOrderNumber();
        long nextOrderNumber = (maxOrderNumber == null) ? 1L : maxOrderNumber + 1L;


        //1.DTO를 엔티티로 변환
        Todo todo = form.toEntity(nextOrderNumber);
        log.info(todo.toString());

        //2. 리파지터리로 엔티티를 DB에 저장
        Todo save = todoRepository.save(todo);
        log.info(save.toString());

        return "redirect:/todo";

    }


    //삭제 컨트롤러
    @PostMapping("/todo/delete/{id}")
    public String deleteTodo(@PathVariable("id") Long id, RedirectAttributes rttr){
        log.info("삭제 요청이 들어왔습니다");

        //1.삭제할 대상 가져오기
        Todo todo = todoRepository.findById(id).orElse(null);
        log.info("삭제할 대상은 "+todo.toString());

        //2. 대상 엔티티 삭제하기
        if(todo!=null) {
            todoRepository.delete(todo);
            rttr.addFlashAttribute("msg","삭제되었습니다!!");
        }

        ArrayList<Todo> all = todoRepository.findAll();
        int i =1;
        for (Todo todo1 : all) {
            todo1.setOrderNumber((long)i);
            i++;
        }
        todoRepository.saveAll(all);


        //3. 결과 페이지로 리다이렉트하기.
        return "redirect:/todo";
    }

    @PostMapping("todo/finished/{id}")
    public String finishedTodo(@PathVariable("id") Long id){

        //Status를 finished로 바꿔줄 target을 id로 찾는다
        Todo target = todoRepository.findById(id).orElse(null);

        // status를 바꿔준다
        target.setStatus("Finished");

        //저장해준다
        todoRepository.save(target);


        //결과 페이지로 리다이렉트하기
        return "redirect:/todo";

    }


}
