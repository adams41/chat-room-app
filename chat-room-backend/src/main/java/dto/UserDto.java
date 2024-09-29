package dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private String username;
    private String email;
    private String password; // Verschlüsselt
    private LocalDateTime registeredAt;

    // Getters and Setters
}