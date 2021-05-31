package com.example.demo.todomongo.config;

import com.example.demo.todomongo.ToDo;
import com.example.demo.todomongo.repository.ToDoRepository;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.demo.todomongo.repository")
public class ToDoConfig extends AbstractMongoClientConfiguration {
    private final Environment environment;
    public ToDoConfig(Environment environment){
        this.environment = environment;
    }

    @Override
    protected String getDatabaseName() {
        return "todoDB";
    }

    @Override
    public com.mongodb.client.MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/todoDB");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return (com.mongodb.client.MongoClient) MongoClients.create(mongoClientSettings);
    }
    @Override
    public Collection getMappingBasePackages() {
        return Collections.singleton("com.example.demo");
    }


    @Bean
    @DependsOn("embeddedMongoServer")
    public MongoClient reactiveMongoClient() {
        int port = environment.getProperty("local.mongo.port",Integer.class);
        return MongoClients.create(String.format("mongodb://localhost:%d", port));
    }
    @Bean
    public CommandLineRunner insertAndView(ToDoRepository repository,
                                           ApplicationContext context){
        return args -> {
            repository.save(new ToDo("Do homework"));
            repository.save(new ToDo("Workout in the mornings", true));
            repository.save(new ToDo("Make dinner tonight"));
            repository.save(new ToDo("Clean the studio", true));
            System.out.println(repository.findAll());
        };
    }
}
