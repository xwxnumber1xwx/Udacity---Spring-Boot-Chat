package com.example.mvc_basics.service;

import com.example.mvc_basics.mapper.MessageMapper;
import com.example.mvc_basics.model.ChatForm;
import com.example.mvc_basics.model.ChatMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private MessageMapper messageMapper;

    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @PostConstruct
    public void postConstruct() {

    }

    public List<ChatMessage> getChatMessages() {
        return this.messageMapper.getAllMessages();
    }

    public void addChatMessages(ChatForm chatForm) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUsername(chatForm.getUsername());
        switch (chatForm.getMessageType()) {
            case "Say":
                chatMessage.setMessageText(chatForm.getMessageText());
                break;
            case "Shout":
                chatMessage.setMessageText(chatForm.getMessageText().toUpperCase());
                break;
            case "Whisper":
                chatMessage.setMessageText(chatForm.getMessageText().toLowerCase());
                break;
            default:
                chatMessage.setMessageText(chatForm.getMessageText());
        }
        this.messageMapper.addMessage(chatMessage);
    }


}
