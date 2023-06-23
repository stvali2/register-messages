package com.example.register.messages;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class Transformer {

    public Message convertFromDto(MessageDto messageDto) {
        Message message = new Message();
        BeanUtils.copyProperties(messageDto, message);
        return message;
    }

    public MessageDto convertToDto(Message message) {
        return new MessageDto(message.id, message.text);
    }
}
