package data.repositories;

import data.models.User;

import java.util.List;

public interface UserRepository {

    User save(User user);
    List<User> findAll();
    long count();
    void delete(int id);
    void delete(User user);
    User findUserById(int id);
}
