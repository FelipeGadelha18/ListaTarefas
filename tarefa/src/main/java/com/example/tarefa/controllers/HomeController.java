package com.example.tarefa.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.tarefa.repositories.TodoRepository;

@Controller
public class HomeController {

    private final TodoRepository todoRepository;

    public  HomeController(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @RequestMapping(path =  "/", method = RequestMethod.GET)
    public ModelAndView home(){
        var modelAndView = new ModelAndView("home");
        modelAndView.addObject("nome", "Felipe e Maria");
        var alunos = List.of("Felipe", "Maria Eduarda", "teste");
        modelAndView.addObject("alunos", alunos);
        return modelAndView;
    }
}
