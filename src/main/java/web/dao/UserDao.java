package web.dao;

import web.model.UserEntity;

import java.util.List;

public interface UserDao {
    List<UserEntity> getAllUsers();
    void addUser(UserEntity user);
    void updateUser(UserEntity user);
    void deleteUser(int id);
}
