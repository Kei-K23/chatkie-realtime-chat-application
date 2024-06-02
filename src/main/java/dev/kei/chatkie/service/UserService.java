package dev.kei.chatkie.service;

import dev.kei.chatkie.entity.Status;
import dev.kei.chatkie.entity.User;
import dev.kei.chatkie.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User save(User user) {
        user.setStatus(Status.ONLINE);
        return userRepository.save(user);
    }

    @Transactional
    public User disconnect(User user) {
        Optional<User> userOptional = userRepository.findByUsername(user.getUsername());
        if(userOptional.isPresent()) {
            userOptional.get().setStatus(Status.OFFLINE);
            return userRepository.save(userOptional.get());
        }
        return null;
    }

    @Transactional(readOnly = true)
    public List<User> findAllOnlineUser() {
        return userRepository.findAllByStatus(Status.ONLINE);
    }
}
