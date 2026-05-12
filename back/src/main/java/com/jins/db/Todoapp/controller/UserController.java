package com.jins.db.Todoapp.controller;

import com.jins.db.Todoapp.model.User;
import com.jins.db.Todoapp.service.UserService;
import com.jins.db.Todoapp.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/profile")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final JwtUtils jwtUtils;

    @PutMapping
    public ResponseEntity<?> update(@RequestBody User user) {
        try {

            User connectedUser = userService.getConnectedUser();
            User updatedUser = userService.Update(user, connectedUser.getId());

            if (updatedUser == null) {
                return ResponseEntity.notFound().build();
            }

            Map<String, Object> authData = new HashMap<>();
            authData.put("token", jwtUtils.generateToken(updatedUser.getEmail()));
            authData.put("type", "Bearer");
            authData.put("user", updatedUser);

            return ResponseEntity.ok(authData);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
