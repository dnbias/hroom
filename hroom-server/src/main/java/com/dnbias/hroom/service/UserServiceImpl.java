package com.dnbias.hroom.service;

import com.dnbias.hroom.repository.UserRepository;
import com.dnbias.hroom.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

import static com.dnbias.hroom.security.SecurityTools.isSanitized;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> fetchUserList() {
        return (List<User>) repository.findAll();
    }

    @Override
    public User updateUser(User user, Long userId) {
        Optional<User> optional = repository.findById(userId);
        if (optional.isEmpty()) {
            // throw new MissingUserException;
            return null;
        }

        User userDB = optional.get();

        if (isSanitized(user.getUsername())) userDB.setUsername(user.getUsername());
        if (isSanitized(user.getName())) userDB.setName(user.getName());
        if (isSanitized(user.getSurname())) userDB.setSurname(user.getSurname());
        if (isSanitized(user.getBirthdate())) userDB.setBirthdate(user.getBirthdate());
        if (isSanitized(user.getCapability())) userDB.setCapability(user.getCapability());
        if (isSanitized(user.getPassword())) userDB.setPassword(user.getPassword());

        return repository.save(userDB);
    }

    @Override
    public void deleteUserById(Long userId) {
        repository.deleteById(userId);
    }

}
