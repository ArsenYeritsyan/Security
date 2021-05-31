package com.example.demo.todo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository<T, ID> extends CrudRepository<T, ID> {



}
