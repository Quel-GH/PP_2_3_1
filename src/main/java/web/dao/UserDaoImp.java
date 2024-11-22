package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

//    public UserDaoImp(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    @Override
    @Transactional
    public List<UserEntity> getAllUsers() {
        return entityManager.createQuery("SELECT a FROM UserEntity a", UserEntity.class).getResultList();
    }

    @Override
    @Transactional
    public void addUser(UserEntity user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(UserEntity user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        entityManager.remove(entityManager.find(UserEntity.class, id));
    }
}
