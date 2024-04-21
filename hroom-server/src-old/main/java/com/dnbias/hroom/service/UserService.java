package com.dnbias.hroom.service;
import com.dnbias.hroom.user.User;
import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> fetchUserList();

    User updateUser(User user, Long userId);

    void deleteUserById(Long userId);
}
