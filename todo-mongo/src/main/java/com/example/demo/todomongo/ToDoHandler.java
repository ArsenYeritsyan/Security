package com.example.demo.todomongo;

import com.example.demo.todomongo.repository.ToDoRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.servlet.function.EntityResponse.fromObject;

@Component
public class ToDoHandler {

    private ToDoRepository repository;

    public ToDoHandler(ToDoRepository repository) {
        this.repository = repository;
    }

    public Mono<ServerResponse> getToDo(ServerRequest request) {
        String toDoId = request.pathVariable("id");
        Mono<ServerResponse> notFound = (Mono<ServerResponse>) ServerResponse.notFound().build();
        ToDo toDo = this.repository.findById(toDoId);
        return toDo
                .flatMap(t ->ServerResponse
                                .ok()
                                .contentType(APPLICATION_JSON)
                                .body(fromObject(t)))
                .switchIfEmpty(notFound);
    }
    public Flux<ServerResponse> getToDos(
            ServerRequest request) {
        Flux<ToDo> toDos = this.repository.findAll();
        return (Mono<ServerResponse>) ServerResponse
                .ok()
                .contentType(APPLICATION_JSON)
                .body(toDos, ToDo.class);
    }
}
