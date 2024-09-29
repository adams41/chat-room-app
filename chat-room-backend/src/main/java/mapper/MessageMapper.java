package mapper;

import dto.ChatMessageDto;
import model.ChatMessage;

import java.time.LocalDateTime;

public class MessageMapper {

    public static ChatMessageDto toDto(ChatMessage message) {
        return new ChatMessageDto(message.getSenderId(), message.getChatRoomId(), message.getMessage(), message.getTimestamp());
    }

    public static ChatMessage toEntity(ChatMessageDto messageDto) {
        ChatMessage message = new ChatMessage();
        message.setSenderId(messageDto.getSenderId());
        message.setChatRoomId(messageDto.getChatRoomId());
        message.setMessage(messageDto.getMessage());
        message.setTimestamp(LocalDateTime.now());
        return message;
    }
}