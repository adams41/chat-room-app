package controller;

import dto.ChatMessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ChatService;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage (@RequestBody ChatMessageDto message) {
        chatService.sendMessage(message);
        return ResponseEntity.ok("Message sent");
    }

    @GetMapping("/history/{chatRoomId}")
    public ResponseEntity<List<ChatMessageDto>> getChatHistory(@PathVariable String chatRoomId) {
        List<ChatMessageDto> chatHistory = chatService.getChatHistory(chatRoomId);
        return ResponseEntity.ok(chatHistory);
    }



}
