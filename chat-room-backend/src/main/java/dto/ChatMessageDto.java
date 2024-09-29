package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor

public class ChatMessageDto {
    private String senderId;
    private String chatRoomId;
    private String message;
    private LocalDateTime timestamp;

    // Getters and Setters
}