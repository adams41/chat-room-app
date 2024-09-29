package service;

import dto.ChatMessageDto;
import model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ChatMessageRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatService {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    public void sendMessage(ChatMessageDto messageDto) {
        kafkaProducerService.sendMessage(messageDto);
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setSenderId(messageDto.getSenderId());
        chatMessage.setChatRoomId(messageDto.getChatRoomId());
        chatMessage.setMessage(messageDto.getMessage());
        chatMessage.setTimestamp(LocalDateTime.now());
        chatMessageRepository.save(chatMessage);
    }

    public List<ChatMessageDto> getChatHistory(String chatRoomId) {
        List<ChatMessage> messages = chatMessageRepository.findByChatRoomIdOrderByTimestampAsc(chatRoomId);
        return messages.stream()
                .map(message -> new ChatMessageDto(message.getSenderId(), message.getChatRoomId(), message.getMessage(), message.getTimestamp()))
                .collect(Collectors.toList());
    }
}