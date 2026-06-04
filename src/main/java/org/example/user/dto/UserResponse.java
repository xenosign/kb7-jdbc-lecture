package org.example.user.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
// Getter / Setter / RequiredArgConstructor / ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private int id;
    private String userId;
    private String name;
    private LocalDateTime createdAt;
}








