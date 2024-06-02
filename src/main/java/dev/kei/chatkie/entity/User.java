package dev.kei.chatkie.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    private String id;
    @Indexed(unique = true)
    private String username;
    private String nickname;
    private Status status;
}
