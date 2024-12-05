package com.springboot.quickstart.model.users;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

@Component
public class UserDao {

    // So basically in order to operate to the database we will be creating a user DAO service
    // or a user data access object service that will contains the method that helps us to
    // intract with the database and the user object

    // So what i wanted to put here is we want to use the JPA/ Hibernate to talk to te database
    private static List<User> users = new ArrayList<>();

    private static int userId = 0;

    static {
        users.add(new User(++userId,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++userId,"Eve",LocalDate.now().minusYears(25)));
        users.add(new User(++userId,"Jim",LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById( int id) {
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        users.removeIf(predicate);
    }



    public User save(User user){
        users.add(new User(++userId,user.getName(),user.getBirthDate()));
        return user;
    }

}
