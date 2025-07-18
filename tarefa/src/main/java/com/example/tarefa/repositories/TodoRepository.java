package com.example.tarefa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.tarefa.models.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}