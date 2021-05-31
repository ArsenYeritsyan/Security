package com.example.demo.todomongo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.servlet.function.RequestPredicates.GET;
import static org.springframework.web.servlet.function.RequestPredicates.accept;
import static org.springframework.web.servlet.function.RouterFunctions.route;


@Configuration
public class ToDoRoutingConfiguration {
    @Bean
    public RouterFunction<ServerResponse>
    monoRouterFunction(ToDoHandler toDoHandler) {
        return
                route(GET("/todo/{id}")
                        .and(accept(MediaType.APPLICATION_JSON)), toDoHandler::getToDos.get()
                        .andRoute(GET("/todo")
                                .and(accept(MediaType.APPLICATION_JSON)), toDoHandler::getToDos);
    }

    }

