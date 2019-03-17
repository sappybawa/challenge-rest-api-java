package com.sappy.challengerest.controller;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Optional;
        import java.util.concurrent.atomic.AtomicLong;

        import com.fasterxml.jackson.annotation.JsonView;
        import com.sappy.challengerest.bonus.Log4J2AsyncLogger;
        import com.sappy.challengerest.exception.NotFoundException;
        import com.sappy.challengerest.jpa.UserRepo;
        import com.sappy.challengerest.model.User;
        import com.sappy.challengerest.view.UserView;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.mongodb.core.MongoOperations;
        import org.springframework.data.mongodb.core.query.Update;
        import org.springframework.web.bind.annotation.*;

        import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
        import static org.springframework.data.mongodb.core.query.Criteria.where;
        import static org.springframework.data.mongodb.core.query.Query.query;

@RestController
public class UserController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    Log4J2AsyncLogger log4J2AsyncLogger;


    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/users")
    public List<User> getListOfUsers() {
        return userRepo.findAll();
    }


    @PostMapping("/users")
    User newUser(@RequestBody User newUser) {
        User user = new User("java beans", "foo");
        newUser.setSeq(generateSequence("user"));
        return userRepo.save(newUser);

    }

    @GetMapping("/users/{id}")
    public Optional<User> getSingleUser(@PathVariable String id) {
        log4J2AsyncLogger.performSomeTask("singleUser");
        return userRepo.findById(id);
    }

    public List<User> reliable() {
        List<User> users = new ArrayList<>();
        return users;
    }

    @GetMapping("/users/")
    public List<User> getUsersByRole(@RequestParam String role) {
        List<User> users = userRepo.findByRole(role);
        if(users.isEmpty()){
            return reliable();
        }else{
            return users;
        }

    }

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
