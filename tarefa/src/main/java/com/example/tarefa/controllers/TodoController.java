package com.example.tarefa.controllers;

import java.lang.module.ResolutionException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.tarefa.repositories.TodoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import com.example.tarefa.models.Todo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




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
    
    @GetMapping("/criar")
    public ModelAndView criar(){
        return new ModelAndView("todo/form", Map.of("todo", new Todo()));
    }
    
    @PostMapping("/criar")
    public String criar(Todo todo){
        todoRepository.save(todo);
        return "redirect:/";
    }
    
    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable Long id){
        var todo = todoRepository.findById(id);
        if(todo.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new ModelAndView("todo/form", Map.of("todo", todo.get()));
    }
    
    @PostMapping("/editar/{id}")
    public String editar(Todo todo){
        
        todoRepository.save(todo);
        return "redirect:/";
    }
   
    
   
    
}
