package com.example.tarefa.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.tarefa.repositories.TodoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TodoController {

    private final TodoRepository todoRepository;

    public  TodoController(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @GetMapping("/")
    public ModelAndView list() {
        var modelAndView = new ModelAndView("todo/list");
        modelAndView.addObject("todos", todoRepository.findAll());
        return modelAndView;
    }
    
   
    
}
