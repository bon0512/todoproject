package com.example.todoproject.repository;

import com.example.todoproject.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface TodoRepository extends JpaRepository<Todo,Long> {

    @Override
    ArrayList<Todo> findAll();

    @Query("SELECT max(t.orderNumber) FROM Todo t")
    Long findMaxOrderNumber();
}
