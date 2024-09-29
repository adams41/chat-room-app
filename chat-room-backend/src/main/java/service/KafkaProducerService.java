package service;

import dto.ChatMessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(ChatMessageDto messageDto) {
        kafkaTemplate.send("chat_topic", messageDto.getMessage());
    }
}