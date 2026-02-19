package com.jins.db.Todoapp.service;

import com.jins.db.Todoapp.model.User;
import com.jins.db.Todoapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> FindByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }
    public User Create(User user) {
        return userRepository.save(user);
    }
    public User Update(User user, Long id) {
        User oldUser = GetById(id);
        if (oldUser != null) {
            oldUser.setPassword(user.getPassword());
            oldUser.setEmail(user.getEmail());
            oldUser.setNom(user.getNom());
            return userRepository.save(oldUser);
        }
        return null;

    }
    public User GetById(Long id) {

        return userRepository.findById(id).orElse(null);
    }
    public User DeleteById(Long id) {
        User user = GetById(id);
        if (user != null) {
            userRepository.delete(user);
            return user;
        }
        return null;

    }
}
