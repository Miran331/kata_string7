package com.example.demo221.dao;

import com.example.demo221.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        User user = findById(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}
