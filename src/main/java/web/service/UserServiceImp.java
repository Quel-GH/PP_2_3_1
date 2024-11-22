package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.UserEntity;

import java.util.List;
@Service
public class UserServiceImp implements UserService {


    UserDao DB;

    public UserServiceImp(UserDao DB) {
        this.DB = DB;
    }

    @Override
    @Transactional
    public List<UserEntity> getAllUsers() {
        return DB.getAllUsers();
    }

    @Override
    @Transactional
    public void addUser(UserEntity user) {
        DB.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(int id, String name, String lastName) {
        DB.updateUser(new UserEntity(id, name, lastName));
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        DB.deleteUser(id);
    }
}
