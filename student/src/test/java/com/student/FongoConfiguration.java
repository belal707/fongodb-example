package com.student;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;

@ComponentScan(basePackages = "com.student.service")
@EnableMongoRepositories(basePackages = "com.student.repo")
@Configuration
public class FongoConfiguration extends AbstractMongoConfiguration 
{
    
    @Override
    protected String getDatabaseName()
    {
        return "student";
    }

    @Bean
    @Override
    public Mongo mongo() throws Exception
    {
        return new Fongo("test").getMongo();
    }
    
    @Override
    protected String getMappingBasePackage() {
        return "com.student.model";
    }

}
