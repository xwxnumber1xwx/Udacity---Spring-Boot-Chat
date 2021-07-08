package com.example.mvc_basics.service;

import com.example.mvc_basics.model.ChatForm;
import com.example.mvc_basics.model.ChatMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private List<ChatMessage> chatMessages;

    @PostConstruct
    public void postConstruct() {
        this.chatMessages = new ArrayList<>();
    }

    public List<ChatMessage> getChatMessages() {
        return chatMessages;
    }

    public void addChatMessages(ChatForm chatForm) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getMode()) {
            case "Say":
                chatMessage.setMessage(chatForm.getMessage());
                break;
            case "Shout":
                chatMessage.setMessage(chatForm.getMessage().toUpperCase());
                break;
            case "Whisper":
                chatMessage.setMessage(chatForm.getMessage().toLowerCase());
                break;
            default:
                chatMessage.setMessage(chatForm.getMessage());
        }
        this.chatMessages.add(chatMessage);
    }


}
