package web.service;

import web.model.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAllUsers();
    void addUser(UserEntity user);
    void updateUser(int id, String name, String lastName);
    void deleteUser(int id);
}
