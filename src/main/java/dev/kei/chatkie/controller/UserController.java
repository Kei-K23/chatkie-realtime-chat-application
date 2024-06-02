package dev.kei.chatkie.controller;

import dev.kei.chatkie.entity.User;
import dev.kei.chatkie.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @MessageMapping("/user.addUser")
    @SendTo("/user/public")
    public User addUser(@Payload User user) {
        return userService.save(user);
    }

    @MessageMapping("/user.disconnectUser")
    @SendTo("/user/public")
    public User disconnect(@Payload User user) {
        return userService.disconnect(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAllOnlineUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAllOnlineUser());
    }
}
