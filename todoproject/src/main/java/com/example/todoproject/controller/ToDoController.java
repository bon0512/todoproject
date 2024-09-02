package com.example.todoproject.controller;

import com.example.todoproject.dto.TodoForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ToDoController {


    @GetMapping("/todo")
    public String indexTodo(Model model){

        model.addAttribute("Enter","엔터");
        return"/todos/list";
    }

    @PostMapping("/todo/create")
    public String createTodo(TodoForm form){
        System.out.println(form.toString());

        return "redirect:/todo";

    }

}
