package com.sappy.challengerest.init;

import com.sappy.challengerest.jpa.UserRepo;
import com.sappy.challengerest.model.User;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(UserRepo repository) {
        return args -> {
            User user = new User("java beans", "foo");
            user.setSeq(generateSequence("user"));
            repository.save(user);
//            System.out.println("Preloading " + repository.save(new User(generateSequence("user"), "java beans", "foo")));
//            System.out.println("Preloading " + repository.save(new User(generateSequence("user"),"coofee mugs", "foo")));
//            System.out.println("Preloading " + repository.save(new User(generateSequence("user"),"cookie bars", "bar")));
        };
    }

    //enable annotation-driven injection
    @Autowired
    private MongoOperations mongoOperations;

    public int generateSequence(String seqName) {
        try {
            User counter = mongoOperations.findAndModify(
                    query(where("_id").is(seqName)),
                    new Update().inc("seq", 1),
                    options().returnNew(true).upsert(true),
                    User.class);
            return counter.getSeq();
        }catch (Exception e){
            return 1;
        }
    }
}