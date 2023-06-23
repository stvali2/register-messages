package com.example.register.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private final MessagesRepository messagesRepository;
    private final Transformer transformer;

    @Autowired
    public MessageService(MessagesRepository messagesRepository, Transformer transformer) {
        this.messagesRepository = messagesRepository;
        this.transformer = transformer;
    }

    public List<MessageDto> getAll() {
        return messagesRepository
                .findAll()
                .stream()
                .map(transformer::convertToDto)
                .collect(Collectors.toList());
    }

    public MessageDto create(MessageDto message) {
        return transformer
                .convertToDto(messagesRepository.insert(transformer.convertFromDto(message)));
    }

    public Optional<MessageDto> read(String id) {
        return messagesRepository
                .findById(id)
                .map(transformer::convertToDto);
    }

    public Optional<MessageDto> update(MessageDto message, String id) {
        return messagesRepository
                .findById(id)
                .map(foundMessage -> {
                    foundMessage.setText(message.getText());
                    messagesRepository.save(foundMessage);
                    return foundMessage;
                })
                .map(transformer::convertToDto);
    }

    public void delete(String id) {
        messagesRepository
                .findById(id)
                .ifPresent(message -> messagesRepository.deleteById(message.getId()));
    }
}
