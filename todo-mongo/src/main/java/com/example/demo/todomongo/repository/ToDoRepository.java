package com.example.demo.todomongo.repository;

import com.example.demo.todomongo.ToDo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends ReactiveMongoRepository<ToDo,String> {

}
