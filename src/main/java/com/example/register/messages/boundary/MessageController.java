package com.example.register.messages.boundary;

import com.example.register.messages.entity.MessageDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@Api(value="register-messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @ApiOperation(value = "View a list of available messages")
    @GetMapping(value = "/messages", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MessageDto> getAll() {
        log.info("find all messages");
        return messageService.getAll();
    }

    @ApiOperation(value = "Create a messages")
    @PostMapping(value = "/messages", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public MessageDto create(@RequestBody MessageDto messageDto) {
        log.info("create message: {}", messageDto);
        return messageService.create(messageDto);
    }

    @ApiOperation(value = "Read a messages")
    @GetMapping("/messages/{id}")
    public Optional<MessageDto> read(@PathVariable String id) {
        log.info("get message with id : {}", id);
        return messageService.read(id);
    }

    @ApiOperation(value = "Update a messages")
    @PutMapping("/messages/{id}")
    public Optional<MessageDto> update(@RequestBody MessageDto messageDto, @PathVariable String id) {
        log.info("update message with id : {} and message : {}", id, messageDto);
        return messageService.update(messageDto, id);
    }

    @ApiOperation(value = "Delete a messages")
    @DeleteMapping("/messages/{id}")
    public void delete(@PathVariable String id) {
        log.debug("delete message with id : {}", id);
        messageService.delete(id);
    }
}
