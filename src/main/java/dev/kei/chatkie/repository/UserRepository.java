package dev.kei.chatkie.repository;

import dev.kei.chatkie.entity.Status;
import dev.kei.chatkie.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
    List<User> findAllByStatus(Status status);
}
