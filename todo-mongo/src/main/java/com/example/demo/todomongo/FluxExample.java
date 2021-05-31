package com.example.demo.todomongo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

@Configuration
public class FluxExample {

    static private Logger LOG = LoggerFactory.getLogger(FluxExample.class);

    @Bean
    public CommandLineRunner runFluxExample() {
        return args -> {
            EmitterProcessor<ToDo> stream =
                    EmitterProcessor.create();
            Flux<ToDo> promise = stream
                    .filter(s -> s.isCompleted())
                    .doOnNext(s -> LOG.info("FLUX >>> ToDo: {}", s.getDescription()));
        };
    }
}