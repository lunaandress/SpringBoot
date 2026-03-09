package com.andres.curso.springboot.error.springboot_error.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.andres.curso.springboot.error.springboot_error.models.User;

@Service
public class UserServiceImple implements UserService {

    private List<User>users;

    //en cualquier clase se puede crear un constructor
    public UserServiceImple() {
        this.users= new ArrayList<>();
        users.add(new User(1L,"Pepe","Gutierrez"));
        users.add(new User(2L,"Susana","Petrolero"));
        users.add(new User(3L,"Carlos","Venrgara"));
        users.add(new User(4L,"Persi","Flamingo"));
        users.add(new User(5L,"Tommy","Franks"));
    }

    @Override
    public Optional<User> findById(long id) {
        User user= null;
        for (User u : users) {
            if (u.getId()==(id)) {
                user=u;
                break;
            }
        }
        return  Optional.ofNullable(user);
    }

    @Override
    public List<User> findAll() {
        return users;
    }


}
