package com.online.store.services;

import com.online.store.dao.DAO;
import com.online.store.dao.UserDAO;
import com.online.store.entity.Role;
import com.online.store.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserService {

    SessionFactory factory = null;

    public static void main(String[] args) {
        UserService userService = new UserService();
        userService.registration();
    }

    public void registration(){
        try {

            factory = new Configuration().configure().buildSessionFactory();
            DAO<User, Integer> dao = new UserDAO(factory);

            User user = new User();
            user.setEmail("vlad.comp.com@gmail.com");
            user.setName("Vlad");
            user.setSurname("Yanytskyi");
            user.setPassword("123");
            Role role = new Role();
            role.setUserRole("Admin");
            user.setRole(role);

            dao.create(user);

            System.out.println("Read first user's: " + dao.read(1));

        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }

}
