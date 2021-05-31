package com.example.demo.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class JpaConfig {
   /* @Bean(name = "h2DataSource")
    public DataSource h2DataSource()
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:file:C:/temp/test");
        dataSourceBuilder.username("username");
        dataSourceBuilder.password("password");
        return dataSourceBuilder.build();
    }  @Autowired
@Qualifier("h2DataSource")
DataSource dataSource;*/




    @Bean(name = "mySqlDataSource")
    @Primary
    public DataSource mySqlDataSource()
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://localhost/todoDB");
        dataSourceBuilder.username("username");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
        /*@Autowired    ----> @Primary
        DataSource dataSource;*/
    }
}
