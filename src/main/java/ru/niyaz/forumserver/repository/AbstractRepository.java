package ru.niyaz.forumserver.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Нияз on 08.02.2017.
 */
public class AbstractRepository {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    protected Session getNewSession() {
        return sessionFactory.openSession();
    }
}
