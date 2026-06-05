package org.example.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPojo {
    @BsonProperty("id")
    private int id;
    @BsonProperty("user_id")
    private String userId;
    private String name;
    private String password;
    @BsonProperty("created_at")
    private LocalDateTime createdAt;
}
