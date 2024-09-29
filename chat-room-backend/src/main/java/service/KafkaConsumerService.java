package service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "chat_topic", groupId = "chat_group")
    public void listen(String message) {
        System.out.println("Received Message in group chat_group: " + message);
    }
}