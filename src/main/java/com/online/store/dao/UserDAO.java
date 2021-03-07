package com.online.store.dao;

import com.online.store.entity.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDAO implements DAO<User, Integer>{

    private final SessionFactory factory;

    public UserDAO(final SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(final User user) {

        try (final Session session = factory.openSession()) {

            session.beginTransaction();

            session.save(user);

            session.getTransaction().commit();
        }
    }

    @Override
    public User read(final Integer id) {

        try (final Session session = factory.openSession()) {

            final User result = session.get(User.class, id);

            if (result != null) {
                Hibernate.initialize(result.getRole());
            }

            return result;
        }
    }

    @Override
    public void update(final User user) {

        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.update(user);

            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(final User user) {

        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.delete(user);

            session.getTransaction().commit();
        }
    }
}
