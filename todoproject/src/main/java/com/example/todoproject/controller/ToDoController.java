package com.example.todoproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToDoController {


    @GetMapping("/todo")
    public String indexTodo(Model model){

        model.addAttribute("Enter","엔터");
        return"/todos/list";
    }

}
