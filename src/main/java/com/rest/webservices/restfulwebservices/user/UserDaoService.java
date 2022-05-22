package com.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static{
        users.add(new User(1, "Roger",new Date()));
        users.add(new User(2, "Rafael",new Date()));
        users.add(new User(3, "Novac",new Date()));
    }

    public List<User> findAllUsers(){
        return users;
    }

    public User addNewUser(User user){
        if(user.getId()!=null) return user;
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public User findUserById(int id){
        for(User user : users){
            if(user.getId() == id)
                return user;
        }
        return null;
    }

    public User removeUser(int id){
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }

}
